package com.library.library_management_system.service.Impl;

import com.library.library_management_system.entities.Book;
import com.library.library_management_system.repository.BookRepository;
import com.library.library_management_system.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;


@Service
public class BookServiceImpl implements BookService {

            @Autowired
            private BookRepository bookRepository;
            public Book addBook(Book book){
                if(book!=null){
                   return bookRepository.save(book);
                }
                return null;
            }

    @Override
    public List<Book> getAllBooks() {

               return bookRepository.findAll();
    }

    @Override
    public Book getBookById(int id) {
            Book book = bookRepository.findById(id).get();
            if(book!=null){
                return book;
            }
            return null;
    }

    public Book updateBook(int id, Book updatedBook) {
        Optional<Book> existingBook = bookRepository.findById(id);
        if (existingBook.isPresent()) {
            Book book = existingBook.get();
            book.setBookName(updatedBook.getBookName());
            book.setBookAuthor(updatedBook.getBookAuthor());
            book.setBookPublisher(updatedBook.getBookPublisher());
            book.setBookISBN(updatedBook.getBookISBN());
            book.setBookQuantity(updatedBook.getBookQuantity());
            book.setSoftDelete(updatedBook.getSoftDelete());
            return bookRepository.save(book);
        }
        return null;
    }


    public Book deleteBookById(int id){
                Book book = bookRepository.findById(id).get();
                if(book!=null){
                    bookRepository.delete(book);
                    return book;
                }
                return null;

    }


}
