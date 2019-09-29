package vleunti.springbootframework.libraryapp.models;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
    //@NotBlank(message = "ID Number is mandatory")
    private Integer idNumber;
    @NotBlank(message = "Address is mandatory")
    private String address;

    public Reader(){

    }

    public Reader(String firstname, String lastname, String email, int idNumber, String address) {
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

    public Integer getId_Number() {
        return idNumber;
    }

    public void setIdNumber(Integer idNumber) {
        this.idNumber = idNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "Reader{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", ID_Number=" + idNumber +
                ", address='" + address + '\'' +
                '}';
    }
}
