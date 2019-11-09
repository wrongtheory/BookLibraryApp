package vleunti.springbootframework.booklibraryapp.services;

import vleunti.springbootframework.booklibraryapp.models.Reader;
import java.util.List;

public interface ReaderService  {

    Reader addNewReader(Reader reader);
    List<Reader> findAllReaders();
    Reader findReaderByIdNumber (Long idNumber);
    int deleteReaderByIdNumber(Long idNumber);
    List getMessages();
    int findAllRegisteredReadersCurrentMonth();


}
