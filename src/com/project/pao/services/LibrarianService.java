package com.project.pao.services;

import com.project.pao.csvIO.LibrarianInput;
import com.project.pao.csvIO.LibrarianOutput;
import com.project.pao.entities.Librarian;

import java.util.ArrayList;
import java.util.List;

public class LibrarianService {

    public static LibrarianService service;

    private LibrarianService() {}

    public static LibrarianService getService() {
        if (service == null)
            service = new LibrarianService();
        return service;
    }

    public List<Librarian> getLibrarians() {

        List<Librarian> librarians = new ArrayList<Librarian>();

        LibrarianInput librarianInput = LibrarianInput.getInput();

        librarians = librarianInput.input(librarians);

        return librarians;
    }

    public void setLibrarians(List<Librarian> librarians) {

        LibrarianOutput librarianOutput = LibrarianOutput.getOutput();

        for (Librarian librarian : librarians) {
            librarianOutput.outputLibrarian(librarian);
        }

    }

}
