package com.crud.library.dao;

import com.crud.library.domain.Rentals;
import com.crud.library.repository.RentalsDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RentalsDaoTestSuite {

    @Autowired
    private RentalsDao rentalsDao;

    @Test
    void testFindByDateOfRentals(){
        // Given
        Rentals rental = new Rentals(LocalDate.of(2023,2,25),LocalDate.of(2023,3,3));
        rentalsDao.save(rental);
        long id = rental.getId();

        // When
        List<Rentals> resultList = rentalsDao.findByDateOfRental(LocalDate.of(2023,2,25));

        // Then
        assertEquals(1, resultList.size());


        //CleanUp
        rentalsDao.deleteById(id);

    }
}
