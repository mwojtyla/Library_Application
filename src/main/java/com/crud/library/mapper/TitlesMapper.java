package com.crud.library.mapper;

import com.crud.library.domain.Readers;
import com.crud.library.domain.ReadersDto;
import com.crud.library.domain.Titles;
import com.crud.library.domain.TitlesDto;
import org.springframework.stereotype.Service;

@Service
public class TitlesMapper {
    public Titles maptoTitles(final TitlesDto titlesDto) {
        return new Titles(
                titlesDto.getId(),
                titlesDto.getTitle(),
                titlesDto.getAuthor(),
                titlesDto.getPublicationYear()
        );
    }

    public TitlesDto mapToTitlesDto(final Titles titles) {
        return new TitlesDto(
                titles.getId(),
                titles.getTitle(),
                titles.getAuthor(),
                titles.getPublicationYear()
        );
    }
}
