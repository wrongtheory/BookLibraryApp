package vleunti.springbootframework.libraryapp.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    @RequestMapping({"/books","/books.html"})
    public String getBooksPage(){
        return "books";
    }
}
