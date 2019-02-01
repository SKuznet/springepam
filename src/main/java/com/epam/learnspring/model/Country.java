package com.epam.learnspring.model;

public class Country {
    private String name;
    private int population;

    @Override
    public String toString() {
        return  "name='" + name + '\'' +
                ", population=" + population +
                ", capital='" + capital + '\'';
    }

    private String capital;

    public Country() {

    }

    public Country(String name, int population, String capital) {
        this.name = name;
        this.population = population;
        this.capital = capital;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
}
