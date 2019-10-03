package vleunti.springbootframework.libraryapp.services;

import org.springframework.stereotype.Service;
import vleunti.springbootframework.libraryapp.models.Reader;
import vleunti.springbootframework.libraryapp.models.repositories.ReaderRepository;

import javax.validation.Valid;
import java.util.List;


public interface ReaderService  {

    Reader create(Reader reader);
    List<Reader> findAll();

}
