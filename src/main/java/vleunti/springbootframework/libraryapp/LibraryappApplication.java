package vleunti.springbootframework.libraryapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"vleunti.springbootframework.libraryapp"})
public class LibraryappApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryappApplication.class, args);
    }

}
