package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class RentalsDto {
    private long Id;

    private LocalDate dateOfRental;
    private LocalDate dateOfReturn;

    //private Copies copies;
    //private Readers readers;
}
