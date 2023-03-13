package com.crud.library.domain;

import org.hibernate.annotations.Cascade;

import javax.validation.constraints.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "COPIES")
public class Copies {
    private long Id;
    private String status;

    private Titles titles;
    private List<Rentals> rentals = new ArrayList<>();

    public Copies() {
    }

    public Copies(String status) {
        this.status = status;
    }

    public Copies(long id, String status, Titles titles) {
        Id = id;
        this.status = status;
        this.titles = titles;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique=true)
    public long getId() {
        return Id;
    }

    @NotNull
    @Column(name = "STATUS")
    public String getStatus() {
        return status;
    }

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "TITLE_ID")
    public Titles getTitles() {
        return titles;
    }

    @OneToMany(
            targetEntity = Rentals.class,
            mappedBy = "copies",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Rentals> getRentals() {
        return rentals;
    }

    public void setTitles(Titles titles) {
        this.titles = titles;
    }

    private void setId(long copyId) {
        this.Id = copyId;
    }

    private void setStatus(String status) {
        this.status = status;
    }

    public void setRentals(List<Rentals> rentals) {
        this.rentals = rentals;
    }
}
