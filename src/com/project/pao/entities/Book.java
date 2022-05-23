package com.project.pao.entities;

public class Book {

    private Integer bookId;
    private String name;
    private String genre;
    private String authorLastName;
    private Integer yearPublished;
    private String description;
    private Integer returnLimit;
    private Boolean loaned;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public Integer getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(Integer yearPublished) {
        this.yearPublished = yearPublished;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getReturnLimit() {
        return returnLimit;
    }

    public void setReturnLimit(Integer returnLimit) {
        this.returnLimit = returnLimit;
    }

    public Boolean getLoaned() {
        return loaned;
    }

    public void setLoaned(Boolean loaned) {
        this.loaned = loaned;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", authorLastName='" + authorLastName + '\'' +
                ", yearPublished=" + yearPublished +
                ", description='" + description + '\'' +
                ", returnLimit=" + returnLimit +
                ", loaned=" + loaned +
                '}';
    }
}
