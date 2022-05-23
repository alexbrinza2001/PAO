package com.project.pao.entities;

public class Author extends Person{

    private Integer authorId;
    private String genre;
    private String mostFamousTitle;
    private Integer yearsActive;

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getMostFamousTitle() {
        return mostFamousTitle;
    }

    public void setMostFamousTitle(String mostFamousTitle) {
        this.mostFamousTitle = mostFamousTitle;
    }

    public Integer getYearsActive() {
        return yearsActive;
    }

    public void setYearsActive(Integer yearsActive) {
        this.yearsActive = yearsActive;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", genre='" + genre + '\'' +
                ", mostFamousTitle='" + mostFamousTitle + '\'' +
                ", yearsActive='" + yearsActive + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nationality='" + nationality + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

}
