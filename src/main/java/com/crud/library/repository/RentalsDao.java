package com.crud.library.repository;

import com.crud.library.domain.Rentals;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface RentalsDao extends CrudRepository<Rentals, Long> {
    List<Rentals> findByDateOfRental(LocalDate dateOfRental);
}
