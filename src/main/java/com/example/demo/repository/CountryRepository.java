package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.demo.entity.Country;

import jakarta.transaction.Transactional;

public interface CountryRepository extends JpaRepository<Country, Integer> {

	public List<Country> findByCountryName(String countryName);
	
	@Query(value = "SELECT * FROM COUNTRY WHERE COUNTRY_NAME LIKE :cl", nativeQuery = true)
	public List<Country> getByDescriptionLike(@Param("cl") String cl);
	
	//Query JPQL
	@Query(value = "FROM Country WHERE countryName LIKE :cl")
	public List<Country> getByDescriptionLikeJPQL(@Param("cl") String cl);
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM COUNTRY WHERE COUNTRY_NAME = :cl", nativeQuery = true)
	public void deleteRowCountryName(@Param("cl") String cl);
}
