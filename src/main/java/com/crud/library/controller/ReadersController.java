package com.crud.library.controller;

import com.crud.library.domain.Readers;
import com.crud.library.domain.ReadersDto;
import com.crud.library.mapper.ReadersMapper;
import com.crud.library.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/library/readers")
@RequiredArgsConstructor
public class ReadersController {

    private final DbService service;
    private final ReadersMapper readersMapper;

    @GetMapping(value = "{readerId}")
    public ResponseEntity<ReadersDto> getReader(@PathVariable Long readerId) throws ReaderNotFoundException {
        return ResponseEntity.ok(readersMapper.mapToReadersDto(service.getReader(readerId)));
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createReader(@RequestBody ReadersDto readersDto) {
        Readers reader = readersMapper.maptoReaders(readersDto);
        service.saveReader(reader);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<ReadersDto> updateReader(@RequestBody ReadersDto readersDto) {
        Readers reader = readersMapper.maptoReaders(readersDto);
        Readers savedReader = service.saveReader(reader);
        return ResponseEntity.ok(readersMapper.mapToReadersDto(savedReader));
    }

    @DeleteMapping(value = "{readerId}")
    public ResponseEntity<Void> deleteReader(@PathVariable Long readerId) {
        service.deleteReader(readerId);
        return ResponseEntity.ok().build();
    }
}
