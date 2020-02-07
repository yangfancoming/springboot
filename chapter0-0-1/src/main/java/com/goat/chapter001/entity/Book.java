package com.goat.chapter001.entity;

/**
 * Created by 64274 on 2018/9/29.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/9/29---15:06
 */
public class Book {

    String bookName;
    String author;

    public Book() {
    }

    public Book(String bookName, String author) {
        this.bookName = bookName;
        this.author = author;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" + "bookName='" + bookName + '\'' + ", author='" + author + '\'' + '}';
    }
}
