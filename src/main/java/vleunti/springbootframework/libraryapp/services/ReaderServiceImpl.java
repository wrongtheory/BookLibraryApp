package vleunti.springbootframework.libraryapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vleunti.springbootframework.libraryapp.models.Book;
import vleunti.springbootframework.libraryapp.models.Reader;
import vleunti.springbootframework.libraryapp.models.repositories.BookRepository;
import vleunti.springbootframework.libraryapp.models.repositories.ReaderRepository;

import javax.validation.ConstraintViolationException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


@Service
public class ReaderServiceImpl implements ReaderService {

    @Autowired
    private ReaderRepository readerRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Reader addNewReader(Reader reader) {
        reader.setDate(LocalDate.now());
        return this.readerRepository.save(reader);
    }

    @Override
    public List<Reader> findAllReaders() {
        List<Reader> readers = new ArrayList<>();
        readerRepository.findAll().forEach(readers::add);
        return readers;
    }

    @Override
    public Reader findReaderByIdNumber(Long idNumber) {
        Reader reader =  readerRepository.findByIdNumber(idNumber);
        return reader;
    }

    @Override
    @Transactional
    public int deleteReaderByIdNumber(Long idNumber) {
        List<Book> allReaderBooks = bookRepository.showAllBooksByReaderId(idNumber);
        System.out.println(allReaderBooks.size());
        if(allReaderBooks.size()==0)
            readerRepository.deleteByIdNumber(idNumber);
        return allReaderBooks.size();
    }

    @Override
    public int findAllRegisteredReadersCurrentMonth() {
        return readerRepository.findAllByMonth();
    }

    public List getMessages(){
       List<String> messages = new ArrayList<>();
       messages.add("Delete Reader");
       messages.add("Give a book");
       messages.add("Return book");
       messages.add("Reader has 1 or more than 1 Book");
       return messages;
    }
}
