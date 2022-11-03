package ru.boris.springboot.LibraryBoot.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Book")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"owner", "createDate", "overdue"})
public class Book {

    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 200)
    @Column(name = "name")
    private String name;

    @Size(max = 100)
    @Column(name = "author")
    private String author;

    @Column(name = "year")
    private int year;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    private Person owner;

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Transient
    private boolean overdue;

}
