package vleunti.springbootframework.libraryapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;


@SpringBootApplication(scanBasePackages = {"vleunti.springbootframework.libraryapp"})
public class LibraryappApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryappApplication.class, args);
    }

}
