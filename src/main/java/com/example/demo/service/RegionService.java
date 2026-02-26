package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Region;
import com.example.demo.repository.RegionRepository;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class RegionService {

	@Autowired
	private RegionRepository regionRepository;
	
	@Transactional(value = TxType.REQUIRED)
	public void insert(Region region) {
		regionRepository.save(region);
	}
	
	@Transactional(value = TxType.REQUIRED)
	public void update(Region region) {
		Optional<Region> local = regionRepository.findById(region.getId());
		if (!local.isEmpty()) {
			local.get().setRegionName(region.getRegionName());
			local.get().setPopulation(region.getPopulation());
			regionRepository.save(local.get());
		}
	}
	
	public List<Region> getAll() {
		return regionRepository.findAll();
	}
	
	public Optional<Region> findById(Integer id) {
		return regionRepository.findById(id);
	}
	
	public List<Region> getRegionByRegionName(String regionName) {
		return regionRepository.findByRegionName(regionName);
	}
	
	public List<Region> getRegionByRegionNameLike(String regionName) {
		return regionRepository.getByDescriptionLike(regionName);
	}
	
	public List<Region> getRegionByRegionNameJPQLLike(String regionName) {
		return regionRepository.getByDescriptionLikeJPQL(regionName);
	}
	
	public void deleteByRegionName(String regionName) {
		regionRepository.deleteRowRegionName(regionName);
	}
}
