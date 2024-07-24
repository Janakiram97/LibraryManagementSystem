package com.example.LibraryManagementSystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Library {
    /*2.Library: Manage a collection of books in  multiple departments. It should include methods:
    3. addBook(Book book): Adds a book to the library's Departments collection (check for duplicates based on ISBN).
    4. removeBook(String ISBN): Removes a book by ISBN .
    5. findBookByTitle(String title): Returns a list of books matching the title(caseinsensitive search).
    6.findBookByAuthor(String author):Returns a list of books by the author(caseinsensitive search).
    7.listAllBooks(): Returns a list of all books in the library .
    8.listAvailableBooks(): Returns a list of available books.
    9.LibraryMenu:(Optional) Create a simple text-based menu for library operations(add,remove, search, list, exit).*/

    private static final Logger log = LoggerFactory.getLogger(Library.class);
    private List<Book> bookList = new ArrayList<>();

    public void addBook(Book book){
        if(isDuplicate(book)){
            log.info("Book already present : {}", book.getISBN());
        }else{
            bookList.add(book);
            log.info("Book added successfully: {} ",book.toString());
        }
    }

    private boolean isDuplicate(Book book) {
      return  bookList.stream()
                .anyMatch(b-> b.getISBN().equalsIgnoreCase(book.getISBN()));
    }

    public void removeBook(String ISBN){
        if(bookList.stream()
                .anyMatch(b-> b.getISBN().equalsIgnoreCase(ISBN))) {
            bookList.removeIf((book -> book.getISBN().equalsIgnoreCase(ISBN)));
            log.info("Book removed successfully : {}", ISBN);
        }else{
            log.info("Book not found : {}", ISBN);
        }
    }

    public List<Book> findBookByTitle(String title){
        List<Book> bookByTitle = bookList.stream().filter(book -> book.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
        if(bookByTitle.isEmpty()){
            log.info("No books found with title : {}", title);
        }
        return bookByTitle;
    }
    public List<Book> findBookByAuthor(String author){
        List<Book> bookByAuthor = bookList.stream().filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
        if(bookByAuthor.isEmpty()){
            log.info("No books found with Author : {}", author);
        }
        return bookByAuthor;
    }
    public List<Book> listAllBooks(){
        return bookList;
    }
    public List<Book> listAvailableBooks()
    {
        return  bookList.stream()
                .filter(Book::isAvailability)
                .collect(Collectors.toList());
    }

}
