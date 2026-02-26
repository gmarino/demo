package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Country;
import com.example.demo.repository.CountryRepository;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;
	
	@Transactional(value = TxType.REQUIRED)
	public void insert(Country country) {
		countryRepository.save(country);
	}
	
	@Transactional(value = TxType.REQUIRED)
	public void update(Country country) {
		Optional<Country> local = countryRepository.findById(country.getId());
		if (!local.isEmpty()) {
			local.get().setCountryName(country.getCountryName());
			local.get().setPopulation(country.getPopulation());
			countryRepository.save(local.get());
		}
	}
	
	public List<Country> getAll() {
		return countryRepository.findAll();
	}
	
	public Optional<Country> findById(Integer id) {
		return countryRepository.findById(id);
	}
	
	public List<Country> getCountryByCountryName(String countryName) {
		return countryRepository.findByCountryName(countryName);
	}
	
	public List<Country> getCountryByCountryNameLike(String countryName) {
		return countryRepository.getByDescriptionLike(countryName);
	}
	
	public List<Country> getCountryByCountryNameJPQLLike(String countryName) {
		return countryRepository.getByDescriptionLikeJPQL(countryName);
	}
	
	public void deleteByCountryName(String countryName) {
		countryRepository.deleteRowCountryName(countryName);
	}
}
