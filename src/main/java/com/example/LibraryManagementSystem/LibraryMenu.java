package com.example.LibraryManagementSystem;

import java.util.List;
import java.util.Scanner;

public class LibraryMenu {
    private Library library;

    public LibraryMenu(Library library) {
        this.library = library;
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("Library Management System Menu");
            System.out.println("1. Add book");
            System.out.println("2. Remove book");
            System.out.println("3. Find Book by Title");
            System.out.println("4. Find Book by Author");
            System.out.println("5. List All Books");
            System.out.println("6. List Available Books");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addBook(scanner);
                    break;
                case 2:
                    removeBook(scanner);
                    break;
                case 3:
                    findBookByTitle(scanner);
                    break;
                case 4:
                    findBookByAuthor(scanner);
                    break;
                case 5:
                    listAllBooks();
                    break;
                case 6:
                    listAvailableBooks();
                    break;
                case 7:
                    System.out.println("Exiting the program...");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private void addBook(Scanner scanner) {
        System.out.println("Enter book title: ");
        String title = scanner.next();
        System.out.println("Enter book ISBN Number: ");
        String isbn = scanner.next();
        System.out.println("Enter book author: ");
        String author = scanner.next();
        System.out.println("Enter book genre: ");
        String genre = scanner.next();
        System.out.println("Enter book publication year: ");
        String publicationYear = scanner.next();
        System.out.println("Enter book department: ");
        String department = scanner.next();
        System.out.println("Enter book availability: ");
        boolean availability = scanner.nextBoolean();
        library.addBook(new Book(title, author, isbn, genre, publicationYear, department, availability));
    }

    private void removeBook(Scanner scanner) {
        System.out.println("enter book ISBN number");
        String isbn = scanner.next();
        library.removeBook(isbn);
    }

    private void findBookByTitle(Scanner scanner) {
        System.out.println("enter book title");
        String title = scanner.next();
        List<Book> bookByTitle = library.findBookByTitle(title);
        System.out.println("Books are :" + bookByTitle);
    }

    private void findBookByAuthor(Scanner scanner) {
        System.out.println("enter book author");
        String author = scanner.next();
        List<Book> booksByAuthor = library.findBookByAuthor(author);
        System.out.println("Books by author are :" + booksByAuthor);
    }

    private void listAllBooks() {
        System.out.println(library.listAllBooks());
    }

    private void listAvailableBooks() {
        System.out.println(library.listAvailableBooks());

    }

}