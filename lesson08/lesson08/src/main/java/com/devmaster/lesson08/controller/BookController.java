package com.devmaster.lesson08.controller;

import ch.qos.logback.core.util.StringUtil;
import com.devmaster.lesson08.entity.Author;
import com.devmaster.lesson08.entity.Book;
import com.devmaster.lesson08.service.AuthorService;
import com.devmaster.lesson08.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;
    private static final String UPLOAD_DIR = "src/main/resources/static";
    private static final String UPLOAD_PathFile="images/products/";

    //Hiển thị toàn bộ sách
    @GetMapping
    public String getBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books/book-list";
    }

    @GetMapping("/new")
    public String newBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("author", authorService.findAll());
        return "books/book-form";
    }
    //Submit new Book
    @PostMapping("/new")
    public String saveBook(@ModelAttribute("book") Book book, @RequestParam List<Long> authorIds, @RequestParam("imageBook") MultipartFile imageFile) {
        if(!imageFile.isEmpty()) {
            try {
                //Tạo thư mục nếu chưa tồn tại
                Path uploadPath = Paths.get(UPLOAD_DIR+UPLOAD_PathFile);
                if(!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }
                //Lấy phần mở rộng của file ảnh
                String originalFilename = StringUtils.cleanPath(Objects.requireNonNull(imageFile.getOriginalFilename()));
                String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));

                //Lưu file trên server
                //String fileName = imageFile.getOrigianlFileName();
                //Path filePath = uploadPath.resolve(fileName);
                //Tạo tên file mới + phần mở rộng gốc
                String newFileName = book.getCode() + fileExtension;
                Path filePath = uploadPath.resolve(newFileName);
                Files.copy(imageFile.getInputStream(), filePath);
                //Lưu đường dẫn ảnh vào imgUrl của book
                book.setImgUrl("/" +UPLOAD_PathFile+"/"+newFileName);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        List<Author> authors = new ArrayList<>(authorService.getAllAuthorsById(authorIds));
        book.setAuthors(authors);
        bookService.saveBook(book);
        return "redirect:/books";

    }

        //Form sửa thông tin sách
        @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        model.addAttribute("author", authorService.findAll());
            return "books/book-form";
        }
        @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBookById(id);
        return "redirect:/books";
        }
}
