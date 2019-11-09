package vleunti.springbootframework.booklibraryapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vleunti.springbootframework.booklibraryapp.models.Book;
import vleunti.springbootframework.booklibraryapp.models.repositories.BookRepository;
import vleunti.springbootframework.booklibraryapp.services.BookService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@Transactional
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookService bookService;

    // Base Book page with the total Books that exists in Database
    @GetMapping("/books")
    public String getBooksPage(Model model){
        model.addAttribute("totalBooks", bookRepository.count());
        return "book/books";
    }

    // Form for adding a new Book
    @GetMapping("/addbook")
    public String viewFormAddBook(){
        return "book/addbook";
    }

    // Method that add a book to Database
    @PostMapping("/addbook")
    public String addBook(@Valid Book book, Model model) {
        model.addAttribute("addbook", bookService.create(book));
        return "redirect:/addbook";
    }

    // Show all Books that are in Database or show all Readers Books
    @GetMapping({"/allbooks","/allbooks{reader_id}"})
    public String getAllBooks(@RequestParam("reader_id") Optional<Long> reader_id, Model model){

        if(reader_id.isPresent()){
            model.addAttribute("showReaderBooks",bookService.findAllBooksByReaderId(reader_id.get()));
            return "book/allbooks";
        }
        else {
            model.addAttribute("allbooks", bookService.findAllBooks());
            return "book/allbooks";
        }
    }

    // Search a Book/multiple Books that contains the entered title
    @GetMapping({"/searchbook", "/searchbook{title}"})
    public String searchBookByTitle(@RequestParam("title") Optional<String> title, Model model, Book book) {
        if (title.isPresent()) {
            List<Book> bookList = bookService.findBookByTitle(title.get());
            model.addAttribute("book", book);
            model.addAttribute("booklist", bookList);
        }
            return "book/searchbook";
    }
}
