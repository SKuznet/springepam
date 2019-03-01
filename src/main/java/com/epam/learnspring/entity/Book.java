package com.epam.learnspring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Book")

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private Long id;

    private String title;

    @ManyToMany(mappedBy = "books",fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Author> authors;
}
