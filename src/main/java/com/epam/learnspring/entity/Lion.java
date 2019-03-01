package com.epam.learnspring.entity;

import javax.persistence.*;

@Entity
@Table (name = "lions")
public class Lion {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "lion_id")
    private Long id;
    private String name;
    private String description;

}
