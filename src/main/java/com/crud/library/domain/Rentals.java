package com.crud.library.domain;


import org.hibernate.annotations.Cascade;

import javax.validation.constraints.NotNull;

import javax.persistence.*;
import javax.validation.groups.Default;
import java.time.LocalDate;


@Entity
@Table(name = "RENTALS")
public class Rentals {

    private long Id;

    private LocalDate dateOfRental;
    private LocalDate dateOfReturn;

    private Copies copies;
    private Readers readers;

    public Rentals() {
    }

    public Rentals(LocalDate dateOfRental, LocalDate dateOfReturn) {
        this.dateOfRental = dateOfRental;
        this.dateOfReturn = dateOfReturn;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique=true)
    public long getId() {
        return Id;
    }


    @NotNull
    @Column(name = "DATE_OF_RENTAL")
    public LocalDate getDateOfRental() {
        return dateOfRental;
    }


    @NotNull
    @Column(name = "DATE_OF_RETURN")
    public LocalDate getDateOfReturn() {
        return dateOfReturn;
    }

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "COPY_ID")
    public Copies getCopies() {
        return copies;
    }

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "READER_ID")
    public Readers getReaders() {
        return readers;
    }

    private void setId(long Id) {
        this.Id = Id;
    }

    private void setDateOfRental(LocalDate dateOfRental) {
        this.dateOfRental = dateOfRental;
    }

    private void setDateOfReturn(LocalDate dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }

    public void setCopies(Copies copies) {
        this.copies = copies;
    }

    public void setReaders(Readers readers) {
        this.readers = readers;
    }
}
