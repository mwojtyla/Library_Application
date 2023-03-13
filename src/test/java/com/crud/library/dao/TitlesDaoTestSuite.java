package com.crud.library.dao;

//import com.crud.library.domain.Copies;
import com.crud.library.domain.Copies;
import com.crud.library.domain.Titles;
import com.crud.library.repository.TitlesDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TitlesDaoTestSuite {

    @Autowired
    private TitlesDao titlesDao;

    @Test
    void testFindByPublicationYear() {
        // Given
        Titles title = new Titles("Message in a bottle", "Nicholas Sparks", 1998);
        titlesDao.save(title);
        long id = title.getId();

        // When
        List<Titles> resultList = titlesDao.findByPublicationYear(1998);

        // Then
        assertEquals(1, resultList.size());

        //CleanUp
        titlesDao.deleteById(id);

    }


    @Test
    void testTitlesDaoSaveWithCopies() {
        // Given
        Titles title = new Titles("Message in a bottle", "Nicholas Sparks", 1998);

        Copies copy = new Copies("Rented");
        Copies copy2 = new Copies("Available");


        title.getCopies().add(copy);
        title.getCopies().add(copy2);
        copy.setTitles(title);
        copy2.setTitles(title);

        // When
        titlesDao.save(title);
        long id = title.getId();

        // Then
        assertNotEquals(0,id);

        //CleanUp
        titlesDao.deleteById(id);

    }

}
