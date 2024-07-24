package com.example.LibraryManagementSystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;


@ExtendWith(MockitoExtension.class)
class LibraryTest {

    Library library;
    Book book1;
    Book book2;
    Book book3;
    @BeforeEach
    void setUp()
    {
        library=new Library();
        book1=new Book("java","ravi","123","software",
                "22/06/2021","It",true);
        book2=new Book("Gcp","rahul","456","software",
                "22/06/2021","It",true);
        book3=new Book("Aws","kiran","545","software",
                "22/06/2019","It",false);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
    }

    @Test
    void addBook_ISBNPresent() {
        Book book=new Book("java","ravi","123","software",
                "22/06/2021","It",true);
        library.addBook(book);
    }
    @Test
    void addBook_ISBNNotPresent() {
        Book book=new Book("Spring Boot","ravi","546","software",
                "22/06/2021","It",true);
        library.addBook(book);
    }

    @Test
    void removeBookTest_ISBNFound(){
        String ISBN="123";
        library.removeBook(ISBN);

        List<Book> bookList = library.listAllBooks();
        assertEquals(2,bookList.size());
    }
    @Test
    void removeBookTest_ISBNNotFound(){
        String ISBN="333";
        library.removeBook(ISBN);

        List<Book> bookList = library.listAllBooks();

        assertFalse(bookList.stream()
                .anyMatch(b->b.getISBN().equalsIgnoreCase(ISBN)));
    }

    @Test
    void findBookByTitleTest_PositiveScenario(){
        String title="java";
        List<Book> bookList = library.findBookByTitle(title);
        assertTrue(bookList.stream().anyMatch(b->b.getTitle().equalsIgnoreCase(title)));
    }
    @Test
    void findBookByTitleTest_NegativeScenario(){
        String title="Jpa";
        List<Book> bookList = library.findBookByTitle(title);
        assertFalse(bookList.stream().anyMatch(b->b.getTitle().equalsIgnoreCase(title)));
    }
    @Test
    void findBookByAuthorTest_PositiveScenario(){
        String author="ravi";
        List<Book> bookList = library.findBookByAuthor(author);
        assertTrue(bookList.stream().anyMatch(b->b.getAuthor().equalsIgnoreCase(author)));
    }

    @Test
    void findBookByAuthorTest_NegativeScenario(){
        String author="Ram";
        List<Book> bookList = library.findBookByAuthor(author);
        assertFalse(bookList.stream().anyMatch(b->b.getAuthor().equalsIgnoreCase(author)));
    }

    @Test
    void listAllBooksTest(){
        List<Book> bookList = library.listAllBooks();
        assertEquals(3, bookList.size());
    }

    @Test
    void listAvailableBooksTest(){
        List<Book> bookList = library.listAvailableBooks();
        assertEquals(2, bookList.size());
    }
}