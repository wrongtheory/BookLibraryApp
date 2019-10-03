package vleunti.springbootframework.libraryapp.models;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "First Name is mandatory")
    private String firstname;
    @NotBlank(message = "Last Name is mandatory")
    private String lastname;
    @NotBlank(message = "E-mail is mandatory")
    private String email;
    //@NotBlank(message = "idNumber is mandatory")
    @Column(unique = true)
    private Long idNumber;
    @NotBlank(message = "Address is mandatory")
    private String address;

    public Reader(){

    }

    public Reader(Long id,String firstname, String lastname, String email, Long idNumber, String address) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.idNumber = idNumber;
        this.address = address;
    }


    public Reader(String firstname, String lastname, String email, Long idNumber, String address) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.idNumber = idNumber;
        this.address = address;
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

    public void setIdNumber(Long idNumber) {

        this.idNumber = idNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
                '}';
    }
}
