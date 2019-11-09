package vleunti.springbootframework.booklibraryapp.models.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vleunti.springbootframework.booklibraryapp.models.Reader;

@Repository
public interface ReaderRepository extends CrudRepository<Reader, Long> {

    Reader findByIdNumber(Long idNumber);
    void deleteByIdNumber(Long idNumber);

    @Query(value = "select count(date) from Reader r where  extract(month from r.date) = extract(month from sysdate)" +
            "and extract(year from r.date) = extract(year from sysdate)",nativeQuery = true)
    int findAllByMonth();


}
