package vleunti.springbootframework.booklibraryapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"vleunti.springbootframework.booklibraryapp"})
public class BookLibraryappApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookLibraryappApplication.class, args);
    }

}
