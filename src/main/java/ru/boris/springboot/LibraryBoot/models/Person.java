package ru.boris.springboot.LibraryBoot.models;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Person")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {"personId", "fullName", "year"})
public class Person {

    @Id
    @Column(name = "person_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int personId;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    @Column(name = "name")
    private String fullName;

    @Min(value = 1900, message = "Age should be greater than 0")
    @Column(name = "year_bd")
    private int year;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "owner")
    private List<Book> books;
}