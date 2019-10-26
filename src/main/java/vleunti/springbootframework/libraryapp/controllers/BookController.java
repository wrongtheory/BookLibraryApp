package vleunti.springbootframework.libraryapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vleunti.springbootframework.libraryapp.models.Book;
import vleunti.springbootframework.libraryapp.models.Reader;
import vleunti.springbootframework.libraryapp.models.repositories.BookRepository;
import vleunti.springbootframework.libraryapp.services.BookService;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookService bookService;

    @GetMapping({"/books"})
    public String getBooksPage(){
        return "book/books";
    }

    @GetMapping("/addbook")
    public String viewForm(){
        return "book/addbook";
    }

    @PostMapping("/addbook")
    public String addBook(@Valid Book book, Model model) {
        model.addAttribute("addbook", bookService.create(book));
        return "redirect:/addbook";
    }



    @GetMapping({"/allbooks","/allbooks{reader_id}"})
    public String getAllBooks(@RequestParam("reader_id") Optional<Long> reader_id, Model model){

        if(reader_id.isPresent()){
            System.out.println("hope este");
            model.addAttribute("showReaderBooks",bookService.findAllBooksByReaderId(reader_id.get()));
            return "book/allbooks";
        }
        else {
            model.addAttribute("allbooks", bookService.findAllBooks());
            return "book/allbooks";
        }
    }

    @GetMapping({"/searchbook","/searchbook{title}"})
    public String searchBookByTitle(@RequestParam("title") Optional<String> title, Model model,Book book){
        if(title.isPresent()) {
            List<Book> bookList = bookService.findBookByTitle(title.get());
            model.addAttribute("book",book);
            model.addAttribute("booklist", bookList);
            return "book/searchbook";
        } else
        {
            return "book/searchbook";}
        }

    /*@GetMapping({"/books"})
    public String getTotalBooks(Model model){
        model.addAttribute("totalBooks", bookRepository.count());
        return "book/books";
    }*/
}
