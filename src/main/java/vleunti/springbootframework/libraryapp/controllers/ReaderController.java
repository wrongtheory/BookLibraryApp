package vleunti.springbootframework.libraryapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;
import vleunti.springbootframework.libraryapp.models.Book;
import vleunti.springbootframework.libraryapp.models.Reader;
import vleunti.springbootframework.libraryapp.models.repositories.BookRepository;
import vleunti.springbootframework.libraryapp.models.repositories.ReaderRepository;
import vleunti.springbootframework.libraryapp.services.BookService;
import vleunti.springbootframework.libraryapp.services.ReaderHasBooksException;
import vleunti.springbootframework.libraryapp.services.ReaderService;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.util.Optional;

@Controller
public class ReaderController {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookService bookService;

    @Autowired
    ReaderRepository readerRepository;

    @Autowired
    ReaderService readerService;


    @GetMapping({"","/","/index"})
    public String getIndexPage(){
        return "index";
    }

    @GetMapping({"/readers"})
    public String getReadersPage(Model model){
            model.addAttribute("countAllRegisteredReaders", readerRepository.count());
           model.addAttribute("currentMonthRegisteredReaders",readerService.findAllByMonth());
        return "reader/readers";
   }

    @GetMapping("/addreader")
    public String viewAddReaderForm(){
        return "reader/addreader";
    }

    @PostMapping("/addreader")
    public String addNewReader(@ModelAttribute @Valid Reader reader, Model model){
        model.addAttribute("addreader", readerService.addNewReader(reader));
        return "redirect:/addreader";
    }

    @GetMapping("/allreaders")
    public String getAllReaders(Model model){
        model.addAttribute("readers",readerService.findAllReaders());
        return "reader/allreaders";
    }

    @GetMapping({"/searchreader","/searchreader{id}","/searchreader{id}/{book_id}"})
    public String searchReaderById(@RequestParam("id") Optional<Long> id, @RequestParam("book_id") Optional<Long> book_id, Model model,Reader reader){
        System.out.println("book_id"+book_id);
        System.out.println("id="+id);

        if(id.isPresent()&&book_id.isPresent()){
            model.addAttribute("givebook",bookService.updateBookSetReaderId(id.get(),book_id.get()));
            return "redirect:/searchreader?id="+reader.getId();
        }
        else
        if(id.isPresent()) {
            //Reader
                    reader = readerService.findReaderByIdNumber(id.get());
            model.addAttribute("reader", reader);
            model.addAttribute("messages",readerService.getMessages());
            model.addAttribute("allbooks",bookService.findAllBooksByReaderId(id.get()));
            System.out.println(reader.getBookSet());
            return "reader/searchreader";
        } else
        {
            return "reader/searchreader";}
        }

  /*  @ExceptionHandler({ReaderHasBooksException.class})
    public ModelAndView getSuperheroesUnavailable(ReaderHasBooksException ex) {
        return new ModelAndView("booksmorethanone", "error", ex.getMessage());
    }*/


    @ExceptionHandler({ReaderHasBooksException.class})
    @GetMapping("/delete")
    public String deleteReadereById(@RequestParam("idNumber") Long id, Model model,Reader reader,ReaderHasBooksException ex) {
            int x = readerService.deleteReaderByIdNumber(id);
        System.out.println("delet method return "+x);
            //return "redirect:/searchreader";
        model.addAttribute("morebooks", readerService.deleteReaderByIdNumber(id));
        return "redirect:/searchreader?id="+reader.getId();
    }

    @GetMapping("/returnbook")
    public String returnBook(@RequestParam("id") Long id, @RequestParam("idNumber") Long idNumber, Book book, Model model,Reader reader){
        //model.addAttribute("setBookReaderIdToNUll",bookService.setBookReaderIdToNull(id));
        System.out.println(idNumber);
        //System.out.println("book id"+book.getId());
        bookService.setBookReaderIdToNull(id);
        //return "redirect:/searchreader?id="+reader.getId();
        return "redirect:/searchreader?id="+idNumber;
    }

}
