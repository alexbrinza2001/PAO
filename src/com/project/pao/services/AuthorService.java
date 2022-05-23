package com.project.pao.services;

import com.project.pao.csvIO.AuthorInput;
import com.project.pao.csvIO.AuthorOutput;
import com.project.pao.entities.Author;

import java.util.ArrayList;
import java.util.List;

public class AuthorService {

    public static AuthorService service;

    private AuthorService() {}

    public static AuthorService getService() {
        if (service == null)
            service = new AuthorService();
        return service;
    }

    public List<Author> getAuthors() {

        List<Author> authors = new ArrayList<Author>();

        AuthorInput authorInput = AuthorInput.getInput();

        authors = authorInput.input(authors);

        return authors;
    }

    public void setAuthors(List<Author> authors) {

        AuthorOutput authorOutput = AuthorOutput.getOutput();

        for (Author author : authors) {
            authorOutput.outputAuthor(author);
        }

    }
}
