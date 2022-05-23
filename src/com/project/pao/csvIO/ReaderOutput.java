package com.project.pao.csvIO;

import com.project.pao.entities.Librarian;
import com.project.pao.entities.Reader;

import java.io.FileWriter;
import java.io.IOException;

public class ReaderOutput {

    public static ReaderOutput output;

    private ReaderOutput() {}

    public static ReaderOutput getOutput() {
        if (output == null)
            output = new ReaderOutput();
        return output;
    }

    public void outputReader(Reader reader){
        try (FileWriter fileWriter = new FileWriter("D:\\Facultate\\Anul 2\\Semestrul 2\\PAO\\PAO\\src\\com\\project\\pao\\CSVFiles\\ReaderOutput.csv", true)) {

            fileWriter.append(reader.getFirstName()).append(",");
            fileWriter.append(reader.getLastName()).append(",");
            fileWriter.append(reader.getNationality()).append(",");
            fileWriter.append(reader.getGender()).append(",");
            fileWriter.append(reader.getEmail()).append(",");
            fileWriter.append(reader.getPhoneNumber());
            fileWriter.append("\n");

            fileWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
