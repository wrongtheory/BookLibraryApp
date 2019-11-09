package vleunti.springbootframework.booklibraryapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vleunti.springbootframework.booklibraryapp.models.Reader;
import vleunti.springbootframework.booklibraryapp.models.repositories.ReaderRepository;
import vleunti.springbootframework.booklibraryapp.services.BookService;
import vleunti.springbootframework.booklibraryapp.services.ReaderService;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@Transactional
public class ReaderController {

    @Autowired
    BookService bookService;

    @Autowired
    ReaderRepository readerRepository;

    @Autowired
    ReaderService readerService;

    // Base Reader page with the total registered Readers that exists in Database
    // and with the Readers registered in current Month
    @GetMapping("/readers")
    public String getReadersPage(Model model) {
        model.addAttribute("countAllRegisteredReaders", readerRepository.count());
        model.addAttribute("currentMonthRegisteredReaders", readerService.findAllRegisteredReadersCurrentMonth());
        return "reader/readers";
    }

    // Form for registering a new Reader
    @GetMapping("/addreader")
    public String viewAddReaderForm() {
        return "reader/addreader";
    }

    // Add a new Reader in Database
    @PostMapping("/addreader")
    public String addNewReader(@ModelAttribute @Valid Reader reader, Model model) {
        model.addAttribute("addreader", readerService.addNewReader(reader));
        return "redirect:/addreader";
    }

    // Show all Readers that exists in Database
    @GetMapping("/allreaders")
    public String showAllReaders(Model model) {
        model.addAttribute("readers", readerService.findAllReaders());
        return "reader/allreaders";
    }

    // When both Reader ID and Book ID are present, then works Adding a Book to a Reader,
    // else when only Reader ID is present works Service Find All Books By Reader ID
    // otherwise return Search Reader Page
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
        }
        return "reader/searchreader";
    }

    // If the Reader has Books, nothing happens because the foregn key in Book Table doesn't
    // permit to delete the Reader, else Reader will successfully deleted
    @GetMapping("/delete")
    public String deleteReadereById(@RequestParam("idNumber") Long id) {
        int x = readerService.deleteReaderByIdNumber(id);
        if (x > 0)
            return "redirect:/searchreader?id=" + id;
        else
            readerService.deleteReaderByIdNumber(id);
        return "redirect:/searchreader";
    }

    // Here works the Service that set the Reader ID Column in table Book to null, that means
    // that Reader had returned the Book
    @GetMapping("/returnbook")
    public String returnBook(@RequestParam("id") Long id, @RequestParam("idNumber") Long idNumber) {
        bookService.setBookReaderIdToNull(id);
        return "redirect:/searchreader?id=" + idNumber;
    }

}
