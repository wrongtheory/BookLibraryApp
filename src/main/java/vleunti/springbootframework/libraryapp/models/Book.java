package vleunti.springbootframework.libraryapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String bookTitle;
    @NotNull
    private String bookAuthor;
    @NotNull
    private Integer bookCopies;

    @ManyToOne
    @JoinColumn(name = "reader_id")
    private Reader reader;

    public Book(String bookTitle, String bookAuthor, Integer bookCopies) {
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookCopies = bookCopies;
    }
}
