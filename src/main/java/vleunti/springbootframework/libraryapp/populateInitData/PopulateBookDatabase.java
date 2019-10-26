package vleunti.springbootframework.libraryapp.populateInitData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import vleunti.springbootframework.libraryapp.models.Book;
import vleunti.springbootframework.libraryapp.models.repositories.BookRepository;
import vleunti.springbootframework.libraryapp.services.BookService;

import java.util.ArrayList;
import java.util.List;

@Component
public class PopulateBookDatabase implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    BookService bookService;

    List<Book> bookList = new ArrayList<>();

    public List<Book> getBookList(){
        System.out.println("Populez carti");
        bookList.add(new Book("Amintiri din Copilarie","Ion Creanga",3));
        bookList.add(new Book("Amintiri de Acasa","Victor Leunti",1));
        bookList.add(new Book("Amintiri de altadata","Vasea Mure",1));
        bookList.add(new Book("Luceafarul","Mihai Eminescu",10));

        for(int i = 0; i<bookList.size();i++)
            bookRepository.save(bookList.get(i));

        return bookList;
    }

    public void initData(){getBookList();}

    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
