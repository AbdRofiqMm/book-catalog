package com.subrutin.catalog.web;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.subrutin.catalog.dto.AuthorCreateRequestDTO;
import com.subrutin.catalog.dto.AuthorResponseDTO;
import com.subrutin.catalog.service.AuthorService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class AuthorResource {

    private final AuthorService authorService;

    @GetMapping("/author/{id}/detail")
    public ResponseEntity<AuthorResponseDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(authorService.findAuthorById(id));
    }

    @PostMapping("/author")
    public ResponseEntity<Void> createNewAuthor(@RequestBody @Valid AuthorCreateRequestDTO dto) {
        authorService.createNewAuthor(dto);
        return ResponseEntity.created(URI.create("/author")).build();
    }

}
