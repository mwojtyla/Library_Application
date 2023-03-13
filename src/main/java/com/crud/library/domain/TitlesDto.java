package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class TitlesDto {
    private long Id;
    private String title;
    private String author;
    private int publicationYear;

    //private List<Copies> copies = new ArrayList<>();
}
