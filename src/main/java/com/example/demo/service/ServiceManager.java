package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Country;
import com.example.demo.entity.Region;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class ServiceManager {

	@Autowired
	private CountryService countryService;
	
	@Autowired
	private RegionService regionService;
	
	@Transactional(value = TxType.REQUIRED)
	public void insertCountryRegion(Country country, Region region) {
		countryService.insert(country);
		regionService.insert(region);
	}
	
	@Transactional(value = TxType.REQUIRED)
	public void insertCountry(Country country) {
		countryService.insert(country);
	}
	
	@Transactional(value = TxType.REQUIRED)
	public void updateCountry(Country country) {
		countryService.update(country);
	}
	
	public Optional<Country> findCountryById(Integer id) {
		return countryService.findById(id);
	}
	
	public List<Country> getCountryByCountryName(String countryName) {
		return countryService.getCountryByCountryName(countryName);
	}
	
	public List<Country> getCountryAll() {
		return countryService.getAll();
	}
	
	public List<Country> getCountryByCountryNameLike(String countryName) {
		return countryService.getCountryByCountryNameLike(countryName);
	}
	
	public List<Country> getCountryByCountryNameJPQLLike(String countryName) {
		return countryService.getCountryByCountryNameJPQLLike(countryName);
	}
	
	public void deleteByCountryName(String countryName) {
		countryService.deleteByCountryName(countryName);
	}
}
