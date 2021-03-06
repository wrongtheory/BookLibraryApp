package vleunti.springbootframework.booklibraryapp.services;

import vleunti.springbootframework.booklibraryapp.models.Book;
import java.util.List;

public interface BookService {

    Book create(Book book);
    List<Book> findBookByTitle(String title);
    Book updateBookSetReaderId(Long reader_id,Long book_id);
    List<Book> findAllBooksByReaderId(Long reader_id);
    void setBookReaderIdToNull(Long reader_id);
    List<Book> findAllBooks();
}


