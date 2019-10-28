package vleunti.springbootframework.libraryapp.models.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vleunti.springbootframework.libraryapp.models.Book;
import vleunti.springbootframework.libraryapp.models.Reader;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book,Long> {

    @Query(value = "SELECT * FROM BOOK where book_title like %:bookTitle%",nativeQuery = true)
    List<Book> findBooksByBookTitle(String bookTitle);

    @Transactional
    @Modifying
    @Query(value = "update Book set reader_id=(select r.id from Reader r where r.id_Number=:reader_id) where id=:book_id",nativeQuery = true)
    Integer updateBookSetReaderId(Long reader_id,Long book_id);

    @Query(value = "select * from Book b inner join Reader on b.reader_id=(select r.id from Reader r where r.id_Number=:reader_id) and reader.id = (select r.id from Reader r where r.id_Number=:reader_id)",nativeQuery = true)
    List<Book> showAllBooksByReaderId(Long reader_id);

    @Transactional
    @Modifying
    @Query(value = "update Book set reader_id=null where id=:book_id",nativeQuery = true)
    Integer updateBookReaderIdToNull(Long book_id);

}