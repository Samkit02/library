package com.library.library_management_system.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "bookcollection")
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private int bookID;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "book_author_name")
    private String bookAuthor;

    @Column(name = "book_publisher")
    private String bookPublisher;

    @Column(name = "book_isbn_number")
    private Double bookISBN;

    @Column(name = "book_quantity")
    private Integer bookQuantity;

    @Column(name = "soft_delete")
    private int softDelete;

    public Book( String bookName, String author, String publisher, Double ISBN, Integer quantity ,int softdelete) {

        this.bookName = bookName;
        this.bookAuthor = author;
        this.bookPublisher = publisher;
        this.bookISBN = ISBN;
        this.bookQuantity = quantity;
        this.softDelete = softdelete;
    }

    public Book() {

    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    public Double getBookISBN() {
        return bookISBN;
    }

    public void setBookISBN(Double bookISBN) {
        this.bookISBN = bookISBN;
    }

    public Integer getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(Integer bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    public int getSoftDelete() {
        return softDelete;
    }

    public void setSoftDelete(int softDelete) {
        this.softDelete = softDelete;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookID=" + bookID +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookPublisher='" + bookPublisher + '\'' +
                ", bookISBN=" + bookISBN +
                ", bookQuantity=" + bookQuantity +
                ", softDelete=" + softDelete +

                '}';
    }


}
