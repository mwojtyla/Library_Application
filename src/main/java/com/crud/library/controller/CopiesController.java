package com.crud.library.controller;

import com.crud.library.domain.Copies;
import com.crud.library.domain.CopiesDto;
import com.crud.library.domain.Readers;
import com.crud.library.domain.ReadersDto;
import com.crud.library.mapper.CopiesMapper;
import com.crud.library.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/library/copies")
@RequiredArgsConstructor
public class CopiesController {

    private final DbService service;
    private final CopiesMapper copiesMapper;


}
