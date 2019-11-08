package vleunti.springbootframework.libraryapp.populateInitData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import vleunti.springbootframework.libraryapp.models.Book;
import vleunti.springbootframework.libraryapp.models.repositories.BookRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class PopulateDatabaseWithBooks implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    BookRepository bookRepository;

    List<Book> bookList = new ArrayList<>();

    public List<Book> getBookList(){
        bookList.add(new Book("In Search of Lost Time","Marcel Proust",3));
        bookList.add(new Book("Ulysses","James Joyce",1));
        bookList.add(new Book("Don Quixote","Miguel de Cervantes",1));
        bookList.add(new Book("The Great Gatsby","F. Scott Fitzgerald",10));

        bookList.add(new Book(" Moby Dick","Herman Melville",6));
        bookList.add(new Book("One Hundred Years of Solitude","Gabriel Garcia Marquez",7));
        bookList.add(new Book("War and Peace","Leo Tolstoy",1));
        bookList.add(new Book("Hamlet","William Shakespeare",5));

        bookList.add(new Book("  Lolita","Vladimir Nabokov",9));
        bookList.add(new Book(" The Odyssey","Homer",4));
        bookList.add(new Book("The Brothers Karamazov","Fyodor Dostoyevsky",2));
        bookList.add(new Book("The Adventures of Huckleberry Finn","Mark Twain",7));


        for(int i = 0; i<bookList.size();i++)
            bookRepository.save(bookList.get(i));

        return bookList;
    }

    public void initData(){getBookList();}

    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
