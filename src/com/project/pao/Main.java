package com.project.pao;

import com.project.pao.dao.repositories.AuthorRepository;
import com.project.pao.dao.repositories.BookRepository;
import com.project.pao.dao.repositories.LibrarianRepository;
import com.project.pao.dao.repositories.ReaderRepository;
import com.project.pao.entities.Author;
import com.project.pao.entities.Book;
import com.project.pao.entities.Librarian;
import com.project.pao.entities.Reader;
import com.project.pao.services.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        AuthorService authorService = AuthorService.getService();
        BookService bookService = BookService.getService();
        ReaderService readerService = ReaderService.getService();
        LibrarianService librarianService = LibrarianService.getService();
        AuditService auditService = AuditService.getService();

        List<Author> authors = authorService.getAuthors();
        List<Book> books = bookService.getBooks();
        List<Reader> readers = readerService.getReaders();
        List<Librarian> librarians = librarianService.getLibrarians();

        Boolean exit = Boolean.FALSE;

        while (!exit) {
            System.out.println("MENU");
            System.out.println("-----");
            System.out.println("0.Exit");
            System.out.println("1.Add a book");
            System.out.println("2.Edit book description");
            System.out.println("3.Remove a book");
            System.out.println("4.Loan a book");
            System.out.println("5.Show all titles from an author");
            System.out.println("6.Show all the names of readers with books loaned");
            System.out.println("7.Register as a new reader");
            System.out.println("8.I want to return a book");
            System.out.println("9.Add a new librarian");
            System.out.println("10.Add a new author");

            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 0 -> exit = true;
                case 1 -> {
                    Book book = new Book();
                    System.out.println("Book Name:" + " ");
                    book.setName(scanner.nextLine());
                    System.out.println("Book Genre:");
                    book.setGenre(scanner.nextLine());
                    System.out.println("Author Last Name:");
                    book.setAuthorLastName(scanner.nextLine());
                    System.out.println("Year Published:");
                    book.setYearPublished(Integer.parseInt(scanner.nextLine()));
                    System.out.println("Short Description:");
                    book.setDescription(scanner.nextLine());
                    System.out.println("Number of days return limit:");
                    book.setReturnLimit(Integer.parseInt(scanner.nextLine()));
                    book.setBookId(books.get(books.size() - 1).getBookId() + 1);
                    books.add(book);

                    auditService.auditWrite("Added a book");
                }
                case 2 -> {
                    System.out.println("Book Name:");
                    String name = scanner.nextLine();
                    System.out.println("New Description:");
                    String newDescription = scanner.nextLine();

                    Boolean ok = Boolean.FALSE;

                    for (Book book : books)
                        if (book.getName().compareTo(name) == 0) {
                            book.setDescription(newDescription);
                            ok = Boolean.TRUE;
                            break;
                        }

                    if (ok == Boolean.FALSE)
                        System.out.println("The book with that name does not exist!");

                    auditService.auditWrite("Edited a book description");
                }
                case 3 -> {
                    System.out.println("Book Name:");
                    String name = scanner.nextLine();

                    for (Book book : books)
                        if (book.getName().compareTo(name) == 0) {
                            books.remove(book);
                            break;
                        }
                    auditService.auditWrite("Removed a book");
                }
                case 4 -> {
                    System.out.println("Reader Last Name:");
                    String readerName = scanner.nextLine();

                    System.out.println("Book desired for loan:");
                    String bookName = scanner.nextLine();

                    for (Book book : books)
                        if (book.getName().compareTo(bookName) == 0)
                            if (book.getLoaned() == Boolean.FALSE) {
                                for (Reader reader : readers)
                                    if (reader.getLastName().compareTo(readerName) == 0){
                                        book.setLoaned(Boolean.TRUE);
                                        reader.getBookList().add(book);
                                    }
                                break;
                            }
                            else {
                                System.out.println("The book was already loaned!");
                                break;
                            }

                    auditService.auditWrite("Loaned a book");
                }
                case 5 -> {
                    System.out.println("Author Last Name:");
                    String authorName = scanner.nextLine();

                    List<String> bookTitles = new ArrayList<String>();

                    for (Book book : books)
                        if (book.getAuthorLastName().compareTo(authorName) == 0)
                            bookTitles.add(book.getName());

                    if (bookTitles.size() == 0)
                        System.out.println("We don't have any titles from that author!");
                    else
                        for (String name : bookTitles)
                            System.out.println(name);


                    auditService.auditWrite("Showed all titles");
                }
                case 6 -> {

                    List<Reader> readerList = new ArrayList<Reader>();

                    for (Reader reader : readers)
                        if (reader.getBookList().size() > 0)
                            readerList.add(reader);

                    if (readerList.size() == 0)
                        System.out.println("There are no books on loan at the moment!");
                    else
                        for (Reader reader : readerList)
                            System.out.println(reader.getFirstName() + reader.getLastName());

                    auditService.auditWrite("Showed all names of readers");
                }
                case 7 -> {
                    Reader reader = new Reader();

                    reader.setReaderId(readers.size() + 1);

                    System.out.println("Your first name:");
                    reader.setFirstName(scanner.nextLine());

                    System.out.println("Your last name:");
                    reader.setLastName(scanner.nextLine());

                    System.out.println("Your nationality:");
                    reader.setNationality(scanner.nextLine());

                    System.out.println("Your gender:");
                    reader.setGender(scanner.nextLine());

                    System.out.println("Your email address:");
                    reader.setEmail(scanner.nextLine());

                    System.out.println("Your phone number:");
                    reader.setPhoneNumber(scanner.nextLine());

                    reader.setBookList(new ArrayList<Book>());

                    readers.add(reader);

                    auditService.auditWrite("Registered a new reader");
                }
                case 8 -> {
                    System.out.println("Your last name:");
                    String name = scanner.nextLine();
                    Boolean ok = Boolean.FALSE;

                    for (Reader reader : readers)
                        if (reader.getLastName().compareTo(name) == 0) {
                            if (reader.getBookList().size() == 0)
                                System.out.println("You don't have any books to return!");
                            else {
                                System.out.println("Name of the book you want to return:");
                                String bookName = scanner.nextLine();
                                Boolean okBook = Boolean.FALSE;
                                for (Book book : reader.getBookList())
                                    if (book.getName().compareTo(bookName) == 0) {
                                        book.setLoaned(Boolean.FALSE);
                                        books.remove(book);
                                        okBook = Boolean.TRUE;
                                    }
                                if (okBook == Boolean.FALSE)
                                    System.out.println("You didn't loan that book!");
                            }
                            ok = Boolean.TRUE;
                        }
                    if (ok == Boolean.FALSE)
                        System.out.println("You are not registered as a reader!");

                    auditService.auditWrite("Tried returning a book");
                }
                case 9 -> {

                    Librarian librarian = new Librarian();

                    librarian.setLibrarianId(librarians.size() + 1);

                    System.out.println("Librarian first name:");
                    librarian.setFirstName(scanner.nextLine());

                    System.out.println("Librarian last name:");
                    librarian.setLastName(scanner.nextLine());

                    System.out.println("Librarian nationality:");
                    librarian.setNationality(scanner.nextLine());

                    System.out.println("Librarian gender:");
                    librarian.setGender(scanner.nextLine());

                    System.out.println("Librarian salary:");
                    librarian.setSalary(Integer.parseInt(scanner.nextLine()));

                    System.out.println("Librarian number of hours worked a week:");
                    librarian.setNumberOfHoursAWeek(Integer.parseInt(scanner.nextLine()));

                    librarians.add(librarian);

                    auditService.auditWrite("Added a new librarian");
                }
                case 10 -> {
                    Author author = new Author();

                    author.setAuthorId(authors.size() + 1);

                    System.out.println("Author first name:");
                    author.setFirstName(scanner.nextLine());

                    System.out.println("Author first name:");
                    author.setLastName(scanner.nextLine());

                    System.out.println("Author first name:");
                    author.setNationality(scanner.nextLine());

                    System.out.println("Author first name:");
                    author.setGender(scanner.nextLine());

                    System.out.println("Author first name:");
                    author.setGenre(scanner.nextLine());

                    System.out.println("Author first name:");
                    author.setMostFamousTitle(scanner.nextLine());

                    System.out.println("Author first name:");
                    author.setYearsActive(Integer.parseInt(scanner.nextLine()));

                    authors.add(author);

                    auditService.auditWrite("Added a new author");
                }
                default -> System.out.println("Please choose one of the options!");
            }
        }

        authorService.setAuthors(authors);
        bookService.setBooks(books);
        librarianService.setLibrarians(librarians);
        readerService.setReaders(readers);

        AuthorRepository authorRepository = AuthorRepository.getAuthorRepository();
        authorRepository.createTable();

        BookRepository bookRepository = BookRepository.getBookRepository();
        bookRepository.createTable();

        LibrarianRepository librarianRepository = LibrarianRepository.getLibrarianRepository();
        librarianRepository.createTable();

        ReaderRepository readerRepository = ReaderRepository.getReaderRepository();
        readerRepository.createTable();

//        authorRepository.insert("William","Shakespeare","English","Male","Plays and poetry","Romeo and Juliet",40);
//        authorRepository.insert("Agatha","Christie","British","Female","Murder and mistery","The Hercule Poirot Series",60);
//        authorRepository.insert("Dan","Brown","American","Male","Thriller","The Da Vinci code",20);
//        authorRepository.insert("Lev","Tolstoy","Russian","Male","Novels","War and Peace",63);
//        authorRepository.insert("Joanne","Rowling","British","Female","Novels","The Harry Potter Series",20);
//        authorRepository.insert("Karl", "May","German","Male","Western","Winnetou",49);
//        authorRepository.select();
//        authorRepository.update(6, 20);
//        authorRepository.select();
//        authorRepository.delete(2);
          authorRepository.select();

//        bookRepository.insert("And then there were none","Mystery","Christie",1939,"The book is the world's best-selling mystery book",15, true);
//        bookRepository.insert("The Da Vinci Code","Mystery","Brown",2003,"The novel explores an alternative religious history",18, false);
//        bookRepository.insert("Angels and demons","Mystery","Brown",2000,"The novel introduces the character Robert Langdon who recurs as the protagonist of Brown's subsequent novels",12, true);
//        bookRepository.insert("Winnetou","Western","May",1893,"Karl May's Winnetou novels symbolize a romantic desire for a simpler life in close contact with nature",20, true);
//        bookRepository.insert("War and Peace","Historical Novel","Tolstoi",1869,"A literary work mixed with chapters on history and philosophy by the Russian author Leo Tolstoy",15, false);
//        bookRepository.select();
//        bookRepository.update(2, true);
//        bookRepository.select();
//        bookRepository.delete(1);
          bookRepository.select();

//        librarianRepository.insert("Jack","Stone","American","Male",2500,30);
//        librarianRepository.insert("Andrew","Jones","British","Male",3000,32);
//        librarianRepository.insert("Andy","Arnold","British","Male",2800,30);
//        librarianRepository.insert("George","Anderson","Brazilian","Male",2400,25);
//        librarianRepository.insert("Andrea","Mancini","Italian","Female",2700,26);
//        librarianRepository.select();
//        librarianRepository.update(5, 3200);
//        librarianRepository.select();
//        librarianRepository.delete(3);
          librarianRepository.select();

//        readerRepository.insert("John","Martin","English","Male","john.martin@gmail.com","0712345678");
//        readerRepository.insert("Alan","Walker","French","Male","alan.walker@gmail.com","0723456789");
//        readerRepository.insert("Frank","Bolton","Australian","Male","frank.bolton@gmail.com","0734567891");
//        readerRepository.insert("Elena","Johnson","Italian","Female","elena.johnson@gmail.com","0745678912");
//        readerRepository.insert("Chloe","Bennett","German","Female","chloe.bennett@gmail.com","0756789123");
//        readerRepository.insert("George","Russell","English","Male","george.russell@gmail.com","0767891234");
//        readerRepository.select();
//        readerRepository.update(4, "elena.johnson1@gmail.com");
//        readerRepository.select();
//        readerRepository.delete(4);
          readerRepository.select();
    }

}
