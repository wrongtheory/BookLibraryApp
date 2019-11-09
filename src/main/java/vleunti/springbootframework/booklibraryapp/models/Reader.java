package vleunti.springbootframework.booklibraryapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
    //@OneToMany(fetch = FetchType.EAGER, mappedBy = "reader")
    private Set<Book> bookSet;


    public Reader(String firstname, String lastname, String email, Long idNumber, String address, LocalDate date ) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.idNumber = idNumber;
        this.address = address;
        this.date = date;
    }
}
