package vleunti.springbootframework.libraryapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import vleunti.springbootframework.libraryapp.models.Reader;
import vleunti.springbootframework.libraryapp.models.repositories.ReaderRepository;

import java.util.*;

@Service
@Primary
public class ReaderServiceImpl implements ReaderService {


    private ReaderRepository readerRepository;

    public ReaderServiceImpl(ReaderRepository readerRepository) {

        this.readerRepository = readerRepository;
    }

    @Override
    public Reader create(Reader reader) {

        return this.readerRepository.save(reader);
    }

    List<Reader> readers = new ArrayList<>();

    @Override
    public List<Reader> findAll() {

        readerRepository.findAll().forEach(readers::add);
        return readers;
    }

}