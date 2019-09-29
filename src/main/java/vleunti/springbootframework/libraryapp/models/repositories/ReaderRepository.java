package vleunti.springbootframework.libraryapp.models.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vleunti.springbootframework.libraryapp.models.Reader;

import java.util.List;

@Repository
public interface ReaderRepository extends CrudRepository<Reader, Long> {

    //List<Reader> findByidNumber(Long id_number);

}
