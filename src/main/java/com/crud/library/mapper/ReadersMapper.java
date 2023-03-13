package com.crud.library.mapper;

import com.crud.library.domain.Readers;
import com.crud.library.domain.ReadersDto;
import org.springframework.stereotype.Service;

@Service
public class ReadersMapper {
    public Readers maptoReaders(final ReadersDto readersDto) {
        return new Readers(
                readersDto.getId(),
                readersDto.getName(),
                readersDto.getSurname(),
                readersDto.getAccountCreationDate()
        );
    }

    public ReadersDto mapToReadersDto(final Readers readers) {
        return new ReadersDto(
                readers.getId(),
                readers.getName(),
                readers.getSurname(),
                readers.getAccountCreationDate()
        );
    }
}
