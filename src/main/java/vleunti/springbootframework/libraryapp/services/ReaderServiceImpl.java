package vleunti.springbootframework.libraryapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import vleunti.springbootframework.libraryapp.models.Reader;
import vleunti.springbootframework.libraryapp.models.repositories.ReaderRepository;

import java.util.List;

@Service
@Primary
public class ReaderServiceImpl implements ReaderService {


    private ReaderRepository readerRepository;

    public ReaderServiceImpl(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

   /* @Override
    public void addReader(String firstname, String lastname, String email, Long id_number, String address) {
        Reader reader = new Reader();
        reader.setFirstname(firstname);
        reader.setLastname(lastname);
        reader.setEmail(email);
        reader.setID_Number(id_number);
        reader.setAddress(address);

        readerRepository.save(reader);
    }*/

    @Override
    public Reader create(Reader reader) {
        return this.readerRepository.save(reader);
    }
}


