package com.crud.library.controller;

import com.crud.library.domain.Titles;
import com.crud.library.domain.TitlesDto;
import com.crud.library.mapper.TitlesMapper;
import com.crud.library.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/library/titles")
@RequiredArgsConstructor
public class TitlesController {

    private final DbService service;
    private final TitlesMapper titlesMapper;


    @GetMapping(value = "{titleId}")
    public ResponseEntity<TitlesDto> getTitle(@PathVariable Long titleId) throws TitleNotFoundException {
        return ResponseEntity.ok(titlesMapper.mapToTitlesDto(service.getTitle(titleId)));
    }



    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createTitle(@RequestBody TitlesDto titlesDto){
        Titles title = titlesMapper.maptoTitles(titlesDto);
        service.saveTitle(title);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<TitlesDto> updateReader(@RequestBody TitlesDto titlesDto){
        Titles title = titlesMapper.maptoTitles(titlesDto);
        Titles savedTitle = service.saveTitle(title);
        return ResponseEntity.ok(titlesMapper.mapToTitlesDto(savedTitle));
    }

    @DeleteMapping(value = "{titleId}")
    public ResponseEntity<Void> deleteTitle(@PathVariable Long titleId){
        service.deleteTitle(titleId);
        return ResponseEntity.ok().build();
    }

}
