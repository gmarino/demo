package com.example.demo.entity;

import java.io.Serializable;

public class Struct implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Country country;
	
	private Region region;
	
	public Struct(Country country, Region region) {
		this.country=country;
		this.region=region;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}
	
	public String toString() {
    	StringBuffer sb = new StringBuffer();
    	sb.append("{Country=").append(country.toString());
    	sb.append(", Region=").append(region.toString());
    	sb.append("}");
    	return sb.toString();
    }
}
