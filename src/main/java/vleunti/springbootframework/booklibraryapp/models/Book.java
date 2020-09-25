package vleunti.springbootframework.booklibraryapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author User
 *
 */
/**
 * @author User
 *
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;
	@NotNull
	public String bookTitle;
	@NotNull
	public String bookAuthor;
	@NotNull
	public Integer bookCopies;

	@ManyToOne
	@JoinColumn(name = "reader_id")
	private Reader reader;
	
	public Book() {}

	public Book(String bookTitle, String bookAuthor, Integer bookCopies) {
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.bookCopies = bookCopies;
	}

	public Long getId() { return id; }

	public void setId(Long id) { this.id = id; }
	  
	public String getBookTitle() { return bookTitle; }

	public void setBookTitle(String bookTitle) { this.bookTitle = bookTitle; }

	public String getBookAuthor() { return bookAuthor; }

	public void setBookAuthor(String bookAuthor) { this.bookAuthor = bookAuthor;}

	public Integer getBookCopies() { return bookCopies; }

	public void setBookCopies(Integer bookCopies) { this.bookCopies = bookCopies;}

	public Reader getReader() { return reader; }

	public void setReader(Reader reader) { this.reader = reader; }

}
