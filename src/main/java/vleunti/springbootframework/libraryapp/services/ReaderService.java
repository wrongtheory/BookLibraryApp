package vleunti.springbootframework.libraryapp.services;

import org.springframework.stereotype.Service;
import vleunti.springbootframework.libraryapp.models.Reader;
import vleunti.springbootframework.libraryapp.models.repositories.ReaderRepository;


public interface ReaderService {

    //public void addReader(String firstname,String lastname,String email,Long id_number,String address);
    Reader create(Reader reader);
}
