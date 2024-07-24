package com.example.LibraryManagementSystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
   Book book;
   @BeforeEach
    void setUp()
    {
       book=new Book("Spring Boot","ravi","546","software",
            "22/06/2021","It",true);
    }
    @Test
    void getTitle() {
        String title="Spring Boot";
        assertEquals(title,book.getTitle());
    }
    @Test
    void getAuthor() {
        String author="ravi";
        assertEquals(author,book.getAuthor());
    }
    @Test
    void getISBN() {
        String ISBN="546";
        assertEquals(ISBN,book.getISBN());
    }
    @Test
    void getGenre() {
        String genre="software";
        assertEquals(genre,book.getGenre());
    }
    @Test
    void getPublicationYear() {
        String publicationYear="22/06/2021";
        assertEquals(publicationYear,book.getPublicationYear());
    }
    @Test
    void getDepartments() {
        String departments="It";
        assertEquals(departments,book.getDepartments());
    }
    @Test
    void isAvailability() {
        assertTrue(book.isAvailability());
    }
   @Test
   void setTitle(){
      String title="AWS";
      book.setTitle(title);
      assertEquals(title,book.getTitle());
    }

    @Test
    void setAuthor(){
       String author="ram";
       book.setAuthor(author);
       assertEquals(author,book.getAuthor());
    }

    @Test
    void setISBN(){
       String ISBN="789";
       book.setISBN(ISBN);
       assertEquals(ISBN,book.getISBN());
    }

    @Test
    void setGenre(){
       String genre="IT";
       book.setGenre(genre);
       assertEquals(genre,book.getGenre());
    }

    @Test
    void setPublicationYear(){
       String publicationYear="23/06/2021";
       book.setPublicationYear(publicationYear);
       assertEquals(publicationYear,book.getPublicationYear());
    }

    @Test
    void setDepartments()
    {
        String department="cloud";
        book.setDepartments(department);
        assertEquals(department,book.getDepartments());
    }

    @Test
    void setAvailability(){
       boolean availability=false;
       book.setAvailability(availability);
       assertFalse(book.isAvailability());
    }
}