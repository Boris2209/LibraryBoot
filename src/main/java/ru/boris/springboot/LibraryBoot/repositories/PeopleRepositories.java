package ru.boris.springboot.LibraryBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.boris.springboot.LibraryBoot.models.Person;


@Repository
public interface PeopleRepositories extends JpaRepository<Person, Integer> {
}
