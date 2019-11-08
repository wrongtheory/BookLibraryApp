package vleunti.springbootframework.libraryapp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import vleunti.springbootframework.libraryapp.models.Book;
import vleunti.springbootframework.libraryapp.models.repositories.BookRepository;
import vleunti.springbootframework.libraryapp.services.BookService;
import vleunti.springbootframework.libraryapp.services.BookServiceImpl;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class BookServiceImplIntegrationTest {

    @TestConfiguration
    static class BookServiceImplTestContextConfiguration{

        @Bean
        public BookService bookService(){
            return new BookServiceImpl();
        }
    }

    @Autowired
    private BookService bookService;

    @MockBean
    private BookRepository bookRepository;

    @Before
    public void setUp(){
        Book book = new Book("In Search of Lost Time","Marcel Proust",3);

        List<Book>  allBooks = Arrays.asList(book);

        Mockito.when(bookRepository.findBooksByBookTitle(book.getBookTitle()))
                .thenReturn(allBooks);
    }

    @Test
    public void whenValidTitle_thenBookShouldBeFound(){
        String title = "In Search of Lost Time";
        List<Book> found  = bookService.findBookByTitle(title);

        assertThat(found.get(0).getBookTitle())
                .isEqualTo(title);

    }


}
