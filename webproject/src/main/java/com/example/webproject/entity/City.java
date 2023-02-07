package com.example.webproject.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "population")
    private Integer population;

    @Column(name = "metro")
    private boolean metro;

    @Column(name = "country")
    private String country;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Attraction> attractions;

    public City() {
    }

    public City(String name, Integer population, boolean metro, String country) {
        this.name = name;
        this.population = population;
        this.metro = metro;
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public boolean isMetro() {
        return metro;
    }

    public void setMetro(boolean metro) {
        this.metro = metro;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Attraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(List<Attraction> attractions) {
        this.attractions = attractions;
    }
}