package com.crud.library.domain;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "READERS")
@CrossOrigin("*")
public final class Readers {
    private long Id;
    private String name;
    private String surname;
    private Date accountCreationDate;
    private List<Rentals> rentals = new ArrayList<>();

    public Readers() {
    }

    public Readers(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.accountCreationDate = new Date();
    }

    public Readers(long id, String name, String surname, Date accountCreationDate) {
        Id = id;
        this.name = name;
        this.surname = surname;
        this.accountCreationDate = accountCreationDate;
    }

    @Id
    @GeneratedValue
   // @NotNull
    @Column(name = "ID", unique=true)
    public long getId() {
        return Id;
    }

   // @NotNull
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    //@NotNull
    @Column(name = "SURNAME")
    public String getSurname() {
        return surname;
    }

   // @NotNull
    @Column(name = "ACCOUNT_CREATION_DATE")
    public Date getAccountCreationDate() {
        return accountCreationDate;
    }

    @OneToMany(
            targetEntity = Rentals.class,
            mappedBy = "readers",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Rentals> getRentals() {
        return rentals;
    }

    private void setId(long Id) {
        this.Id = Id;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setSurname(String surname) {
        this.surname = surname;
    }

    private void setAccountCreationDate(Date accountCreationDate) {
        this.accountCreationDate = accountCreationDate;
    }

    public void setRentals(List<Rentals> rentals) {
        this.rentals = rentals;
    }
}
