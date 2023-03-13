package com.crud.library.dao;


import com.crud.library.domain.*;
import com.crud.library.repository.CopiesDao;
import com.crud.library.repository.ReadersDao;
import com.crud.library.repository.RentalsDao;
import com.crud.library.repository.TitlesDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ReadersDaoTestSuite {

    @Autowired
    private ReadersDao readersDao;

    @Autowired
    private TitlesDao titlesDao;

    @Autowired
    private CopiesDao copiesDao;
    @Autowired
    private RentalsDao rentalsDao;

    @Test
    void testFindByName(){
        // Given
        Readers reader = new Readers("Joe", "Cartright");
        readersDao.save(reader);
        long id = reader.getId();
        String name = reader.getName();

        // When
        List<Readers> resultList = readersDao.findByName(name);

        // Then
        assertEquals(1, resultList.size());

        //CleanUp
        readersDao.deleteById(id);

    }

    @Test
    void testReadersDaoSaveWithRentals() {
        // Given
        Titles title = new Titles("Message in a bottle", "Nicholas Sparks", 1998);
        Titles title2 = new Titles("Notebook", "Nicholas Sparks", 1997);
        Copies copy = new Copies("Rented");
        Copies copy2 = new Copies("Returned");

        Readers reader = new Readers("Joe", "Cartright");
        Rentals rental = new Rentals(LocalDate.of(2023,3,5),LocalDate.of(1,1,1));
        Rentals rental2 = new Rentals(LocalDate.of(2023,2,25),LocalDate.of(2023,3,3));


        copy.setTitles(title);
        copy2.setTitles(title2);
        title.getCopies().add(copy);
        title2.getCopies().add(copy2);

        rental.setCopies(copy);
        rental2.setCopies(copy2);
        copy.getRentals().add(rental);
        copy2.getRentals().add(rental2);

        rental.setReaders(reader);
        rental2.setReaders(reader);
        reader.getRentals().add(rental);
        reader.getRentals().add(rental2);


        // When
        titlesDao.save(title);
        titlesDao.save(title2);
        copiesDao.save(copy);
        copiesDao.save(copy2);
        readersDao.save(reader);
        rentalsDao.save(rental);
        rentalsDao.save(rental2);

        long readerId = reader.getId();

        // Then
        assertNotEquals(0,readerId);

        //CleanUp
        readersDao.deleteById(readerId);
    }

}
