package vleunti.springbootframework.libraryapp.models.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vleunti.springbootframework.libraryapp.models.Reader;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface ReaderRepository extends CrudRepository<Reader, Long> {
    Reader findByIdNumber(Long idNumber);
    void deleteByIdNumber(Long idNumber);

    /*@Query(value = "select count(date) from Reader r where month(r.date) = :month",nativeQuery = true)
    Integer findAllByMonth(Integer month);
*/
    @Query(value = "select count(date) from Reader r where  extract(month from r.date) = extract(month from sysdate)" +
            "and extract(year from r.date) = extract(year from sysdate)",nativeQuery = true)
    int findAllByMonth();


}
