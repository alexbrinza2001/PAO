package com.project.pao.csvIO;

import com.project.pao.entities.Author;

import java.io.*;
import java.util.List;

public class AuthorInput {

    public static AuthorInput input;

    private AuthorInput() {}

    public static AuthorInput getInput() {
        if (input == null)
            input = new AuthorInput();
        return input;
    }

    public List<Author> input(List<Author> authors) {

        try {
            BufferedReader buffer = new BufferedReader(new FileReader("D:\\Facultate\\Anul 2\\Semestrul 2\\PAO\\PAO\\src\\com\\project\\pao\\CSVFiles\\AuthorCsv.csv"));
            String line = buffer.readLine();

            while (line != null) {
                String[] params = line.split(",");
                Author author = new Author();

                author.setAuthorId(Integer.parseInt(params[0]));
                author.setFirstName(params[1]);
                author.setLastName(params[2]);
                author.setNationality(params[3]);
                author.setGender(params[4]);
                author.setGenre(params[5]);
                author.setMostFamousTitle(params[6]);
                author.setYearsActive(Integer.parseInt(params[7]));

                authors.add(author);

                line = buffer.readLine();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }

        return authors;
    }

}
