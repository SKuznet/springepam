package com.epam.learnspring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Author")

public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "author_id")
    private Long id;

    private String name;

    @ManyToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @JoinTable(
            name = "Author_Book",
            joinColumns = {@JoinColumn(name = "author_id")},
            inverseJoinColumns = { @JoinColumn(name = "book_id")}
    )
    @JsonIgnore
    private List<Book> books;

}
