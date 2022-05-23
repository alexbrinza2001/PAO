package com.project.pao.csvIO;

import com.project.pao.entities.Librarian;

import java.io.FileWriter;
import java.io.IOException;

public class LibrarianOutput {

    public static LibrarianOutput output;

    private LibrarianOutput() {}

    public static LibrarianOutput getOutput() {
        if (output == null)
            output = new LibrarianOutput();
        return output;
    }

    public void outputLibrarian(Librarian librarian){
        try (FileWriter fileWriter = new FileWriter("D:\\Facultate\\Anul 2\\Semestrul 2\\PAO\\PAO\\src\\com\\project\\pao\\CSVFiles\\LibrarianOutput.csv", true)) {

            fileWriter.append(librarian.getFirstName()).append(",");
            fileWriter.append(librarian.getLastName()).append(",");
            fileWriter.append(librarian.getNationality()).append(",");
            fileWriter.append(librarian.getGender()).append(",");
            fileWriter.append(librarian.getSalary().toString()).append(",");
            fileWriter.append(librarian.getNumberOfHoursAWeek().toString());
            fileWriter.append("\n");

            fileWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
