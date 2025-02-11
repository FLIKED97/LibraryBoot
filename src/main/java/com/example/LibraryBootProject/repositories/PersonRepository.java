package com.example.LibraryBootProject.repositories;


import com.example.LibraryBootProject.models.Book;
import com.example.LibraryBootProject.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    @Query("SELECT p FROM Person p JOIN p.books b WHERE b = :book")
    Person findBookOwner(@Param("book") Book book);
}
