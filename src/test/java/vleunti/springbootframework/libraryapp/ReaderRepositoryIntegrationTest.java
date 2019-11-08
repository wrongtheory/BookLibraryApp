package vleunti.springbootframework.libraryapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import vleunti.springbootframework.libraryapp.models.Reader;
import vleunti.springbootframework.libraryapp.models.repositories.ReaderRepository;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ReaderRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ReaderRepository readerRepository;

    @Test
    public void whenFindByIdNumber_then_ReturnReader(){

        //given
        Reader reader = new Reader("Robert","Price","rprice@yahoo.com",48792L,"Reaver Street 1", LocalDate.now());
        entityManager.persist(reader);
        entityManager.flush();

        //when
        Reader found = readerRepository.findByIdNumber(reader.getIdNumber());

        //then
        assertThat(found.getIdNumber())
                .isEqualTo(reader.getIdNumber());

    }


}
