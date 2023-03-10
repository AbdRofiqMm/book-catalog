package com.subrutin.catalog.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.subrutin.catalog.domain.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    // method name convention
    // find+keyword
    // sql -> select * from Author a where a.id = authorId
    public Optional<Author> findById(Long authorId);

    // sql -> select a from Author a where a.author_name = :author_name
    public List<Author> findByNameLike(String authorName);

}
