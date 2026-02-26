package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "COUNTRY")
public class Country {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "countryName",nullable = false)
    String countryName;

    @Column(name = "population",nullable = false)
    Long population;

    public Country() {
        super();
    }

    public Country(int i, String countryName, Long population) {
        super();
        this.id = i;
        this.countryName = countryName;
        this.population = population;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }
    
    public String toString() {
    	StringBuffer sb = new StringBuffer();
    	sb.append("[ id=").append(id);
    	sb.append(", countryName=").append(countryName);
    	sb.append(", population=").append(population).append(" ]");
    	return sb.toString();
    }

}