package com.epam.learnspring.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "universes")
public class Universe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @OneToMany(fetch = FetchType.EAGER)
    private List<SuperHero> heroesOfUniversity;

    @OneToMany(fetch = FetchType.EAGER)
    private List<SuperVillain> villainOfUniversity;

    public Universe(String title) {
        this.title = title;
    }
}
