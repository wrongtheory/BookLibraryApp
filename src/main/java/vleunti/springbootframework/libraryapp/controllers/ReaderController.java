package vleunti.springbootframework.libraryapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vleunti.springbootframework.libraryapp.models.Reader;
import vleunti.springbootframework.libraryapp.models.repositories.ReaderRepository;

import javax.validation.Valid;

@Controller
public class ReaderController {

    @Autowired
    ReaderRepository readerRepository;

    @Autowired
    public ReaderController(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    @RequestMapping({"","/","/index","/index.html"})
    public String getIndexPage(){

        return "index";
    }

    @RequestMapping({"/books","/books.html"})
    public String getBooksPage(){
        return "books";
    }

    @GetMapping("/readers")
    public String getClientsPage(){
        return "reader/readers";
    }

    @GetMapping("/addreader")
    public String viewForm(){
        return "reader/addreader";
    }

    @PostMapping(value="/addreader")
    public String saveReader(@ModelAttribute("reader") @Valid Reader reader, Model model){

        model.addAttribute("reader", readerRepository.save(reader));
        reader.setFirstname(null);
        reader.setLastname(null);
        reader.setEmail(null);
        reader.setId(null);
        reader.setAddress(null);
        return "reader/addreader";
    }


    @RequestMapping("/allreaders")
    public String getAllUsers(Reader reader, Model model){
        model.addAttribute("readers",readerRepository.findAll());
        return "reader/allreaders";
    }

    @GetMapping("/searchreader")
    public String searchUser(){
        return "reader/searchreader";
    }
}
