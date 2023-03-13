package com.crud.library.mapper;

import com.crud.library.domain.Copies;
import com.crud.library.domain.CopiesDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CopiesMapper {

    public Copies mapToCopies(final CopiesDto copiesDto){
        return new Copies(
                copiesDto.getId(),
                copiesDto.getStatus(),
                copiesDto.getTitles()
        );
    }

    public CopiesDto mapToCopiesDto(final Copies copies){
        return new CopiesDto(
                copies.getId(),
                copies.getStatus(),
                copies.getTitles()
        );
    }

    public List<CopiesDto> mapToCopiesDtoList(final List<Copies> copiesList) {
        return copiesList.stream()
                .map(this::mapToCopiesDto)
                .toList();

    }
}
