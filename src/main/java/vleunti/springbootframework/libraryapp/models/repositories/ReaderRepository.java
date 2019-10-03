package vleunti.springbootframework.libraryapp.models.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vleunti.springbootframework.libraryapp.models.Reader;

@Repository
public interface ReaderRepository extends CrudRepository<Reader, Long> {



}
