package vleunti.springbootframework.libraryapp.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "First Name is mandatory")
    private String firstname;

    @NotNull(message = "Last Name is mandatory")
    private String lastname;

    private String email;

    @NotNull(message = "idNumber is mandatory")
    @Column(unique = true)
    private Long idNumber;

    @NotNull(message = "Address is mandatory")
    private String address;

    private LocalDate date;

    @OneToMany(mappedBy = "reader")
    private Set<Book> bookSet;

    public Reader(){}

    public Reader(String firstname, String lastname, String email, Long idNumber, String address, LocalDate date ) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.idNumber = idNumber;
        this.address = address;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public void setIdNumber(Long idNumber) { this.idNumber = idNumber; }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Set<Book> getBookSet() {
        return bookSet;
    }

    public void setBookSet(Set<Book> bookSet) {
        this.bookSet = bookSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reader reader = (Reader) o;
        return idNumber == reader.idNumber &&
                id.equals(reader.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idNumber);
    }

    @Override
    public String toString() {
        return "Reader{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", idNumber=" + idNumber +
                ", address='" + address + '\'' +
                ", datetime='" + date + '\'' +
                '}';
    }
}
