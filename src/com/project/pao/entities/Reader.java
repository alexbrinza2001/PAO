package com.project.pao.entities;

import java.util.Set;

public class Reader extends Person{

    private Integer readerId;
    private String email;
    private String phoneNumber;
    private Set<Book> bookList;

    public Integer getReaderId() {
        return readerId;
    }

    public void setReaderId(Integer readerId) {
        this.readerId = readerId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Book> getBookList() {
        return bookList;
    }

    public void setBookList(Set<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nationality='" + nationality + '\'' +
                ", gender='" + gender + '\'' +
                ", readerId=" + readerId +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", bookList=" + bookList +
                '}';
    }

    @Override
    public int compareTo(Reader reader) {
        if (getLastName() == null || reader.getLastName() == null) {
            return 0;
        }
        return getLastName().compareTo(reader.getLastName());
    }
}
