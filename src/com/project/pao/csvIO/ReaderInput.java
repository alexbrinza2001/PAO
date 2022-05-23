package com.project.pao.csvIO;

import com.project.pao.entities.Book;
import com.project.pao.entities.Reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.List;

public class ReaderInput {

    public static ReaderInput input;

    private ReaderInput() {}

    public static ReaderInput getInput() {
        if (input == null)
            input = new ReaderInput();
        return input;
    }

    public List<Reader> input(List<Reader> readers) {

        try {
            BufferedReader buffer = new BufferedReader(new FileReader("D:\\Facultate\\Anul 2\\Semestrul 2\\PAO\\PAO\\src\\com\\project\\pao\\CSVFiles\\ReaderCsv.csv"));
            String line = buffer.readLine();

            while (line != null) {
                String[] params = line.split(",");
                Reader reader = new Reader();

                reader.setReaderId(Integer.parseInt(params[0]));
                reader.setFirstName(params[1]);
                reader.setLastName(params[2]);
                reader.setNationality(params[3]);
                reader.setGender(params[4]);
                reader.setEmail(params[5]);
                reader.setPhoneNumber(params[6]);
                reader.setBookList(new HashSet<Book>());

                readers.add(reader);

                line = buffer.readLine();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }

        return readers;
    }
}
