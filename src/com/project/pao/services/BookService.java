package com.project.pao.services;

import com.project.pao.csvIO.BookInput;
import com.project.pao.csvIO.BookOutput;
import com.project.pao.entities.Book;

import java.util.ArrayList;
import java.util.List;

public class BookService {

    public static BookService service;

    private BookService() {}

    public static BookService getService() {
        if (service == null)
            service = new BookService();
        return service;
    }

    public List<Book> getBooks() {

        List<Book> books = new ArrayList<Book>();

        BookInput bookInput = BookInput.getInput();

        books = bookInput.input(books);

        return books;
    }

    public void setBooks(List<Book> books) {

        BookOutput bookOutput = BookOutput.getOutput();

        for (Book book : books) {
            bookOutput.outputBook(book);
        }

    }

}
