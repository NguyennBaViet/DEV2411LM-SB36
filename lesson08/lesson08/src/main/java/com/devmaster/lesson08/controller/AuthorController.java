package com.devmaster.lesson08.controller;

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
import java.util.UUID;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;
    private static final String UPLOAD_DIR = "src/main/resources/static";
    private static final String UPLOAD_PathFile="images/products/";

    @GetMapping
    public String getAllAuthors(Model model) {
        model.addAttribute("authors", authorService.findAll());
        return "authors/author-list";
    }

    @GetMapping("/new")
    public String newAuthor(Model model) {
        model.addAttribute("author", new Author());
        return "authors/author-form";
    }

    @PostMapping("/new")
    public String saveAuthor(@ModelAttribute("author") Author author,@RequestParam("imageAuthor") MultipartFile imageAuthor) {
        if(!imageAuthor.isEmpty()) {
            try {
                //Tạo thư mục nếu chưa tồn tại
                Path uploadPath = Paths.get(UPLOAD_PathFile+UPLOAD_DIR);
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }
                String originalFileName = StringUtils.cleanPath(Objects.requireNonNull(imageAuthor.getOriginalFilename()));
                String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
                String newFileName = author.getCode() + fileExtension;
                Files.copy(imageAuthor.getInputStream(), uploadPath.resolve(newFileName));
                author.setImgUrl("/" + UPLOAD_PathFile+"/" + newFileName);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return "redirect:/authors";
    }
    @GetMapping("/edit/{id}")
    public String editAuthor(@PathVariable("id") Long id, Model model) {
        Author author = authorService.findById(id);
        model.addAttribute("author", author);
        model.addAttribute("authors", authorService.findAll());
        return "authors/author-form";
    }
    @GetMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable("id") Long id) {
        authorService.delete(id);
        return "redirect:/authors";
    }
}
