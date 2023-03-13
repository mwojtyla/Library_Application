package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;


@Getter
@AllArgsConstructor
public class ReadersDto {
    private long Id;
    private String name;
    private String surname;
    private Date accountCreationDate;

    //private List<Rentals> rentals = new ArrayList<>();
}
