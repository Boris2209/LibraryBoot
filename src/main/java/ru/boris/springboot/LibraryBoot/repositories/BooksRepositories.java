package ru.boris.springboot.LibraryBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.boris.springboot.LibraryBoot.models.Book;


import java.util.List;

@Repository
public interface BooksRepositories extends JpaRepository<Book, Integer> {
    List<Book> findByNameStartingWith(String startingWith);
}
