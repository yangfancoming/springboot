package com.goat.graphql.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import com.goat.graphql.dto.Author;
import com.goat.graphql.dto.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookQueryResolver implements GraphQLQueryResolver {


    public List<Book> findBooks() {
        Author author = new Author(1,"Bill Venners",40);
        Book book = new Book(1,"scala编程第三版",author,"电子工业出版社");
        List<Book> bookList = new ArrayList<>();
        bookList.add(book);
        return bookList;
    }


}
