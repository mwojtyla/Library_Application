package com.crud.library.domain;

import javax.validation.constraints.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TITLES")
public class Titles {
    private long Id;
    private String title;
    private String author;
    private int publicationYear;

    private List<Copies> copies = new ArrayList<>();

    public Titles() {
    }

    public Titles(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public Titles(long id, String title, String author, int publicationYear) {
        Id = id;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique=true)
    public long getId() {
        return Id;
    }



    @NotNull
    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    @NotNull
    @Column(name = "AUTHOR")
    public String getAuthor() {
        return author;
    }

    @NotNull
    @Column(name = "PUBLICATION_YEAR")
    public int getPublicationYear() {
        return publicationYear;
    }

    @OneToMany(
            targetEntity = Copies.class,
            mappedBy = "titles",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Copies> getCopies() {
        return copies;
    }

    private void setId(long Id) {
        this.Id = Id;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    private void setAuthor(String author) {
        this.author = author;
    }

    private void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setCopies(List<Copies> copies) {
        this.copies = copies;
    }
}
