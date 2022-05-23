package com.project.pao.entities;

import java.util.List;

public class Library {

    private Integer libraryId;
    private List<Librarian> librarianList;
    private List<Reader> readerList;
    private List<Book> bookList;
    private List<Section> sectionList;

    public Integer getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Integer libraryId) {
        this.libraryId = libraryId;
    }

    public List<Librarian> getLibrarianList() {
        return librarianList;
    }

    public void setLibrarianList(List<Librarian> librarianList) {
        this.librarianList = librarianList;
    }

    public List<Reader> getReaderList() {
        return readerList;
    }

    public void setReaderList(List<Reader> readerList) {
        this.readerList = readerList;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public List<Section> getSectionList() {
        return sectionList;
    }

    public void setSectionList(List<Section> sectionList) {
        this.sectionList = sectionList;
    }

    @Override
    public String toString() {
        return "Library{" +
                "libraryId=" + libraryId +
                ", librarianList=" + librarianList +
                ", readerList=" + readerList +
                ", bookList=" + bookList +
                ", sectionList=" + sectionList +
                '}';
    }
}
