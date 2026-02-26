package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "REGION")
public class Region {

	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "regionName",nullable = false)
    String regionName;

    @Column(name = "population",nullable = false)
    Long population;

    public Region() {
        super();
    }

    public Region(int i, String regionName, Long population) {
        super();
        this.id = i;
        this.regionName = regionName;
        this.population = population;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
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
    	sb.append(", regionName=").append(regionName);
    	sb.append(", population=").append(population).append(" ]");
    	return sb.toString();
    }
}
