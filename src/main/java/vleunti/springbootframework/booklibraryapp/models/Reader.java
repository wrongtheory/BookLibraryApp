package vleunti.springbootframework.booklibraryapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reader {
	
	public Reader() {
		// TODO Auto-generated constructor stub
	}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @NotNull(message = "First Name is mandatory")
    public String firstname;

    @NotNull(message = "Last Name is mandatory")
    public String lastname;

    public String email;

    @NotNull(message = "idNumber is mandatory")
    @Column(unique = true)
    public Long idNumber;

    @NotNull(message = "Address is mandatory")
    public String address;

    public LocalDate date;
    
    public Reader(String firstname, String lastname, String email, Long idNumber, String address, LocalDate date ) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.idNumber = idNumber;
        this.address = address;
        this.date = date;
    }
    
    public LocalDate getDate() {
    	return date;
    }

    @OneToMany(mappedBy = "reader")
    //@OneToMany(fetch = FetchType.EAGER, mappedBy = "reader")
    public Set<Book> bookSet;

    

    public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(Long idNumber) {
		this.idNumber = idNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<Book> getBookSet() {
		return bookSet;
	}

	public void setBookSet(Set<Book> bookSet) {
		this.bookSet = bookSet;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Long getId() {
		return id;
	}


}
