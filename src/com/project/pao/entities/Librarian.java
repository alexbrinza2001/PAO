package com.project.pao.entities;

import java.util.List;

public class Librarian extends Person{

    private Integer librarianId;
    private Integer salary;
    private Integer numberOfHoursAWeek;
    private List<Section> sectionList;

    public Integer getLibrarianId() {
        return librarianId;
    }

    public void setLibrarianId(Integer librarianId) {
        this.librarianId = librarianId;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getNumberOfHoursAWeek() {
        return numberOfHoursAWeek;
    }

    public void setNumberOfHoursAWeek(Integer numberOfHoursAWeek) {
        this.numberOfHoursAWeek = numberOfHoursAWeek;
    }

    public List<Section> getSectionList() {
        return sectionList;
    }

    public void setSectionList(List<Section> sectionList) {
        this.sectionList = sectionList;
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "librarianId=" + librarianId +
                ", salary=" + salary +
                ", numberOfHoursAWeek=" + numberOfHoursAWeek +
                ", sectionList=" + sectionList +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nationality='" + nationality + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
