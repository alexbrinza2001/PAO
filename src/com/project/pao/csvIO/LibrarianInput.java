package com.project.pao.csvIO;

import com.project.pao.entities.Librarian;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

public class LibrarianInput {
    public static LibrarianInput input;

    private LibrarianInput() {}

    public static LibrarianInput getInput() {
        if (input == null)
            input = new LibrarianInput();
        return input;
    }

    public List<Librarian> input(List<Librarian> librarians) {

        try {
            BufferedReader buffer = new BufferedReader(new FileReader("D:\\Facultate\\Anul 2\\Semestrul 2\\PAO\\PAO\\src\\com\\project\\pao\\CSVFiles\\LibrarianCsv.csv"));
            String line = buffer.readLine();

            while (line != null) {
                String[] params = line.split(",");
                Librarian librarian = new Librarian();

                librarian.setLibrarianId(Integer.parseInt(params[0]));
                librarian.setFirstName(params[1]);
                librarian.setLastName(params[2]);
                librarian.setNationality(params[3]);
                librarian.setGender(params[4]);
                librarian.setSalary(Integer.parseInt(params[5]));
                librarian.setNumberOfHoursAWeek(Integer.parseInt(params[6]));

                librarians.add(librarian);

                line = buffer.readLine();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }

        return librarians;
    }
}
