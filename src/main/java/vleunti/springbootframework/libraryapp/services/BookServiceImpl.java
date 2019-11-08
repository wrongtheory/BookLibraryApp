package vleunti.springbootframework.libraryapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vleunti.springbootframework.libraryapp.models.Book;
import vleunti.springbootframework.libraryapp.models.repositories.BookRepository;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book create(Book book) {
        return this.bookRepository.save(book);
    }

    @Override
    public List<Book> findBookByTitle(String title) {
        List<Book> books = new ArrayList<>();
        bookRepository.findBooksByBookTitle(title).forEach(books::add);

        return  books;
    }
    @Override
    public Book updateBookSetReaderId(Long reader_id,Long book_id){
        Book book = new Book();
        bookRepository.updateBookSetReaderId(reader_id,book_id);

        return book;
    }

    @Override
    public List<Book> findAllBooksByReaderId(Long reader_id) {
        List<Book> books = new ArrayList<>();
        bookRepository.showAllBooksByReaderId(reader_id).forEach(books::add);

        return books;
    }

    @Override
    public void setBookReaderIdToNull(Long book_id){
        bookRepository.updateBookReaderIdToNull(book_id);
    }

    @Override
    public List<Book> findAllBooks() {
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(books::add);

        return books;
    }
}
