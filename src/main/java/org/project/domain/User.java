package org.project.domain;

import javax.persistence.*;

@Entity
@Table(name="User")
public class User {

    @Id
    @GeneratedValue(generator = "project_generator")
    @SequenceGenerator(
            name = "project_generator",
            sequenceName = "project_sequence",
            initialValue = 1
    )
    @Column(name="id", unique = true)
    private long id;

    @Column(nullable = true)
    private String firstName;
    @Column(nullable = true)
    private String lastName;
    @Column(nullable = true)
    private String password;
    @Column(nullable = true)
    private String telephoneNumber;
    @Column(nullable = true)
    private String address;

    public void viewMovies() { }
    public void bookTicket (){ }
    public void cancelTicket() {}
    public void makePayment() {}
    public void addMovieRecords() {}
    public void deleteMovieRecords(){}
    public void updateMovieRecords(){}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
