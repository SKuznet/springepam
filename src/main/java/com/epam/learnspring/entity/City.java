package com.epam.learnspring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String type;

    @Column(columnDefinition = "DATE")
    private LocalDate year;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "cityList")
    private List<Rocker> rockers = new ArrayList<>();

    public List<Rocker> getRockers() {
        return rockers;
    }

    public void setRockers(List<Rocker> rockers) {
        this.rockers = rockers;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String model) {
        this.type = type;
    }

    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }
}
