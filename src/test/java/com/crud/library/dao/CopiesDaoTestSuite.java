package com.crud.library.dao;

import com.crud.library.domain.*;
import com.crud.library.repository.CopiesDao;
import com.crud.library.repository.TitlesDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CopiesDaoTestSuite {

    @Autowired
    private CopiesDao copiesDao;

    @Autowired
    private TitlesDao titlesDao;

    @Test
    void testFindByStatus(){
        // Given
        Copies copy = new Copies("Rented");
        copiesDao.save(copy);
        long id = copy.getId();

        // When
        List<Copies> resultList = copiesDao.findByStatus("Rented");

        // Then
        assertEquals(1, resultList.size());


        //CleanUp
        copiesDao.deleteById(id);
    }

    @Test
    void testCopiesDaoSaveWithRentals() {
        // Given
        Titles title = new Titles("Message in a bottle", "Nicholas Sparks", 1998);
        Copies copy = new Copies("Rented");

        Rentals rental = new Rentals(LocalDate.of(2023,2,25),LocalDate.of(2023,3,3));
        Rentals rental2 = new Rentals(LocalDate.of(2023,3,5),LocalDate.of(1,1,1));

        copy.setTitles(title);
        title.getCopies().add(copy);

        copy.getRentals().add(rental);
        copy.getRentals().add(rental2);
        rental.setCopies(copy);
        rental2.setCopies(copy);

        // When
        titlesDao.save(title);
        copiesDao.save(copy);
        long copyId = copy.getId();
        long titleId = title.getId();

        // Then
        assertNotEquals(0,copyId);

        //CleanUp
        copiesDao.deleteById(copyId);
        titlesDao.deleteById(titleId);
    }
}
