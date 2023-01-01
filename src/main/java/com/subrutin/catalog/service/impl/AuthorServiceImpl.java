package com.subrutin.catalog.service.impl;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.subrutin.catalog.domain.Author;
import com.subrutin.catalog.dto.AuthorCreateRequestDTO;
import com.subrutin.catalog.dto.AuthorResponseDTO;
import com.subrutin.catalog.exception.BadRequestException;
import com.subrutin.catalog.repository.AuthorRepository;
import com.subrutin.catalog.service.AuthorService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public AuthorResponseDTO findAuthorById(Long id) {
        // 1. Fetch data dari database
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("invalid.authorId"));
        // 2. Author -> AuthorResponseDTO
        AuthorResponseDTO dto = new AuthorResponseDTO();
        dto.setAuthorName(author.getName());
        dto.setBirthDate(author.getBirthData().toEpochDay());
        return dto;
    }

    @Override
    public void createNewAuthor(AuthorCreateRequestDTO dto) {

        Author author = new Author();
        author.setName(dto.getAuthorName());
        author.setBirthData(LocalDate.ofEpochDay(dto.getBirthDate()));

        authorRepository.save(author);
    }

}
