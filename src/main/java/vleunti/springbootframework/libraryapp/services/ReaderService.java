package vleunti.springbootframework.libraryapp.services;

import vleunti.springbootframework.libraryapp.models.Reader;
import java.util.List;

public interface ReaderService  {

    Reader addNewReader(Reader reader);
    List<Reader> findAllReaders();
    Reader findReaderByIdNumber (Long idNumber);
    int deleteReaderByIdNumber(Long idNumber);
    public List getMessages();
    int findAllByMonth();


}
