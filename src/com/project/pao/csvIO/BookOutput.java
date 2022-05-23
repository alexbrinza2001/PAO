package com.project.pao.csvIO;

import com.project.pao.entities.Book;

import java.io.FileWriter;
import java.io.IOException;

public class BookOutput {

    public static BookOutput output;

    private BookOutput() {}

    public static BookOutput getOutput() {
        if (output == null)
            output = new BookOutput();
        return output;
    }

    public void outputBook(Book book){
        try (FileWriter fileWriter = new FileWriter("D:\\Facultate\\Anul 2\\Semestrul 2\\PAO\\PAO\\src\\com\\project\\pao\\CSVFiles\\BookOutput.csv", true)) {

            fileWriter.append(book.getName()).append(",");
            fileWriter.append(book.getGenre()).append(",");
            fileWriter.append(book.getAuthorLastName()).append(",");
            fileWriter.append(book.getYearPublished().toString()).append(",");
            fileWriter.append(book.getDescription()).append(",");
            fileWriter.append(book.getReturnLimit().toString());
            fileWriter.append("\n");

            fileWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
