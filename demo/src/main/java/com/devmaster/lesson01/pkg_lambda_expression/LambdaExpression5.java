package com.devmaster.lesson01.pkg_lambda_expression;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class Book{
    int id;
    String name;
    float price;
    public Book(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
public class LambdaExpression5 {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<Book>();
        books.add(new Book(1, "Lập trình Java", 9.95f));
        books.add(new Book(2, "Lập trình SpringBoot", 8.85f));
        books.add(new Book(3, "PHP Laravel", 11.5f));
        books.add(new Book(4, "NetCore API", 22.1f));
        books.add(new Book(5, "Javascript", 7.36f));

        books.stream().forEach(System.out::println);
        System.out.println("====================");
        //Lọc sách có giá trị lớn hơn 15
        Stream<Book> filter = books.stream().filter(b->b.price > 15);
        filter.forEach(System.out::println);
    }
}
