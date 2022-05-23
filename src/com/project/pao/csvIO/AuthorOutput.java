package com.project.pao.csvIO;

import com.project.pao.entities.Author;

import java.io.FileWriter;
import java.io.IOException;

public class AuthorOutput {

    public static AuthorOutput output;

    private AuthorOutput() {}

    public static AuthorOutput getOutput() {
        if (output == null)
            output = new AuthorOutput();
        return output;
    }

    public void outputAuthor(Author author){
        try (FileWriter fileWriter = new FileWriter("D:\\Facultate\\Anul 2\\Semestrul 2\\PAO\\PAO\\src\\com\\project\\pao\\CSVFiles\\AuthorOutput.csv", true)) {

            fileWriter.append(author.getFirstName()).append(",");
            fileWriter.append(author.getLastName()).append(",");
            fileWriter.append(author.getNationality()).append(",");
            fileWriter.append(author.getGender()).append(",");
            fileWriter.append(author.getGenre()).append(",");
            fileWriter.append(author.getMostFamousTitle()).append(",");
            fileWriter.append(author.getYearsActive().toString());
            fileWriter.append("\n");

            fileWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
