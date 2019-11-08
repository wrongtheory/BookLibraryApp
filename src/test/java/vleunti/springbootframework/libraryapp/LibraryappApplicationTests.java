package vleunti.springbootframework.libraryapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import vleunti.springbootframework.libraryapp.controllers.BookController;
import vleunti.springbootframework.libraryapp.controllers.HomeController;
import vleunti.springbootframework.libraryapp.controllers.ReaderController;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {HomeController.class, BookController.class,ReaderController.class})
@ContextConfiguration(classes = LibraryappApplication.class)
public class LibraryappApplicationTests {

    @Autowired
    private HomeController homeController;

    @Autowired
    private BookController bookController;

    @Autowired
    ReaderController readerController;

    @Test
    public void contextLoads() {

        assertThat(homeController).isNotNull();
        assertThat(readerController).isNotNull();
        assertThat(bookController).isNotNull();

    }

}
