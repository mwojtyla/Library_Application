package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CopiesDto {
    private long Id;
    private String status;
    private Titles titles;
    //private List<Rentals> rentals = new ArrayList<>();
}
