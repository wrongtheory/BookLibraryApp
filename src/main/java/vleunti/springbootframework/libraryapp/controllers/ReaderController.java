package vleunti.springbootframework.libraryapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vleunti.springbootframework.libraryapp.models.Book;
import vleunti.springbootframework.libraryapp.models.Reader;
import vleunti.springbootframework.libraryapp.models.repositories.BookRepository;
import vleunti.springbootframework.libraryapp.models.repositories.ReaderRepository;
import vleunti.springbootframework.libraryapp.services.BookService;
import vleunti.springbootframework.libraryapp.services.ReaderHasBooksException;
import vleunti.springbootframework.libraryapp.services.ReaderService;

import javax.validation.Valid;
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

    @Autowired
    ReaderHasBooksException readerHasBooksException;


    @GetMapping({"", "/", "/index"})
    public String getIndexPage() {
        return "index";
    }

    @GetMapping("/readers")
    public String getReadersPage(Model model) {
        model.addAttribute("countAllRegisteredReaders", readerRepository.count());
        model.addAttribute("currentMonthRegisteredReaders", readerService.findAllRegisteredReadersCurrentMonth());
        return "reader/readers";
    }

    @GetMapping("/addreader")
    public String viewAddReaderForm() {
        return "reader/addreader";
    }

    @PostMapping("/addreader")
    public String addNewReader(@ModelAttribute @Valid Reader reader, Model model) {
        model.addAttribute("addreader", readerService.addNewReader(reader));
        return "redirect:/addreader";
    }

    @GetMapping("/allreaders")
    public String showAllReaders(Model model) {
        model.addAttribute("readers", readerService.findAllReaders());
        return "reader/allreaders";
    }

    @GetMapping({"/searchreader", "/searchreader{id}", "/searchreader{id}/{book_id}"})
    public String searchReaderById(@RequestParam("id") Optional<Long> id, @RequestParam("book_id") Optional<Long> book_id, Model model, Reader reader) {

        if (id.isPresent() && book_id.isPresent()) {
            model.addAttribute("givebook", bookService.updateBookSetReaderId(id.get(), book_id.get()));
            return "redirect:/searchreader?id=" + reader.getId();
        }
        else if (id.isPresent()) {
            reader = readerService.findReaderByIdNumber(id.get());
            model.addAttribute("reader", reader);
            model.addAttribute("messages", readerService.getMessages());
            model.addAttribute("allbooks", bookService.findAllBooksByReaderId(id.get()));
            return "reader/searchreader";
        }
        else {
            return "reader/searchreader";
        }
    }

    @GetMapping("/delete")
    public String deleteReadereById(@RequestParam("idNumber") Long id, Model model, Reader reader, ReaderHasBooksException ex) {
        int x = readerService.deleteReaderByIdNumber(id);
        model.addAttribute("error", readerHasBooksException.mess);
        if (x > 0)
        {
            model.addAttribute("error", readerHasBooksException.mess);
            return "redirect:/searchreader?id=" + id;
        } else
            readerService.deleteReaderByIdNumber(id);
        return "redirect:/searchreader";

    }

    @GetMapping("/returnbook")
    public String returnBook(@RequestParam("id") Long id, @RequestParam("idNumber") Long idNumber) {
        bookService.setBookReaderIdToNull(id);
        return "redirect:/searchreader?id=" + idNumber;
    }

}
