package com.example.LibraryBootProject.repositories;


import com.example.LibraryBootProject.models.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByOwner_Id(int personId);
    Page<Book> findAll(Pageable pageable);

    Optional<Book> findByNameBookStartingWithIgnoreCase(String nameBook);

}
