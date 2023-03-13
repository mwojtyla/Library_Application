package com.crud.library;

import com.crud.library.domain.ReadersDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@SpringBootApplication
public class LibraryApplication {

    public static void main(String[] args) {
       /* ReadersDto readerDto = new ReadersDto(
                (long)1,
                "name",
                "surname",
                new Date()
        );

        Long id = readerDto.getId();
        String name = readerDto.getName();
        String surname = readerDto.getSurname();

        System.out.println(id + " " + name + " " + surname + new Date());*/
        SpringApplication.run(LibraryApplication.class, args);
    }

}
