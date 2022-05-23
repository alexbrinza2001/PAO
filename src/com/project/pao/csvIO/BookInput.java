package com.project.pao.csvIO;

import com.project.pao.entities.Book;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

public class BookInput {

    public static BookInput input;

    private BookInput() {}

    public static BookInput getInput() {
        if (input == null)
            input = new BookInput();
        return input;
    }

    public List<Book> input(List<Book> books) {

        try {
            BufferedReader buffer = new BufferedReader(new FileReader("D:\\Facultate\\Anul 2\\Semestrul 2\\PAO\\PAO\\src\\com\\project\\pao\\CSVFiles\\BookCsv.csv"));
            String line = buffer.readLine();

            while (line != null) {
                String[] params = line.split(",");
                Book book = new Book();

                book.setBookId(Integer.parseInt(params[0]));
                book.setName(params[1]);
                book.setGenre(params[2]);
                book.setAuthorLastName(params[3]);
                book.setYearPublished(Integer.parseInt(params[4]));
                book.setDescription(params[5]);
                book.setReturnLimit(Integer.parseInt(params[6]));
                book.setLoaned(Boolean.FALSE);

                books.add(book);

                line = buffer.readLine();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }

        return books;
    }
}
