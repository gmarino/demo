package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.demo.entity.Region;

import jakarta.transaction.Transactional;

public interface RegionRepository extends JpaRepository<Region, Integer> {

	public List<Region> findByRegionName(String regionName);
	
	@Query(value = "SELECT * FROM REGION WHERE REGION_NAME LIKE :cl", nativeQuery = true)
	public List<Region> getByDescriptionLike(@Param("cl") String cl);
	
	//Query JPQL
	@Query(value = "FROM Region WHERE regionName LIKE :cl")
	public List<Region> getByDescriptionLikeJPQL(@Param("cl") String cl);
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM REGION WHERE REGION_NAME = :cl", nativeQuery = true)
	public void deleteRowRegionName(@Param("cl") String cl);
}
