package com.epam.learnspring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "superVillains")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuperVillain implements SuperGuys{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToOne
    private Person alterEgo;

    @ManyToOne(cascade = CascadeType.ALL)
    private Universe universe;

    @ManyToMany
    private List<SuperPower> superPowers;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<SuperHero> enemies;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<SuperVillain> allies;

}
