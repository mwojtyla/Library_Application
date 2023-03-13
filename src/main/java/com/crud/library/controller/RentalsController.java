package com.crud.library.controller;

import com.crud.library.domain.CopiesDto;
import com.crud.library.domain.RentalsDto;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/library/rentals")
public class RentalsController {

    @GetMapping
    public List<RentalsDto> getRentals() {
        return new ArrayList<>();
    }

    @GetMapping(value = "{rentalId}")
    public RentalsDto getRental(@PathVariable Long rentalId) {
        return new RentalsDto(1L,LocalDate.of(2023,1,1),LocalDate.of(2023,2,2));
    }

    @PostMapping
    public void createRental(RentalsDto rentalsDto) {
    }

    // wypożyczenie książki
    @PutMapping
    public RentalsDto updateRental(RentalsDto rentalsDto){
       return new RentalsDto(1, LocalDate.of(2023,2,25),LocalDate.of(2023,3,3));
    }

    // zwrot książki
    @DeleteMapping
    public void deleteRental(Long rentalId){
    }

}
