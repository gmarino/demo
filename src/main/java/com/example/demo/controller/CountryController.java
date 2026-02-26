package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Country;
import com.example.demo.entity.Region;
import com.example.demo.entity.Struct;
import com.example.demo.service.ServiceManager;

@Controller
@RequestMapping("/api/countryctrl")
public class CountryController {

	private static final Logger logger = LoggerFactory.getLogger(CountryController.class);
	
	@Value("${server.instance.id}")
	private String instanceId;
	
	@Autowired
    private ServiceManager serviceManager;
	
	//Insert Country data
	@PostMapping(value = "/insert", produces = "application/json")
	public ResponseEntity<String> insert(@RequestBody Country country) {
		logger.info("# insert [instance="+instanceId+"], country:"+country);
		serviceManager.insertCountry(country);
		return new ResponseEntity<String>("Country record added", HttpStatus.OK);
	}
	
	//Insert Country and region data
	@PostMapping(value = "/insertStruct", produces = "application/json")
	public ResponseEntity<String> insertCountryRegion(@RequestBody Struct struct) {
		logger.info("# insert [instance="+instanceId+"], country:"+struct.getCountry());
		logger.info("# insert [instance="+instanceId+"], region:"+struct.getRegion());
		serviceManager.insertCountryRegion(struct.getCountry(), struct.getRegion());
		return new ResponseEntity<String>("Country and Region records added", HttpStatus.OK);
	}
	
	//Update Country data
	@PutMapping(value = "/update", produces = "application/json")
	public ResponseEntity<String> update(@RequestBody Country country) {
		logger.info("# insert [instance="+instanceId+"], country:"+country);
		serviceManager.updateCountry(country);
		return new ResponseEntity<String>("Country record added", HttpStatus.OK);
	}
	
	//findById
	@GetMapping(value = "/findById/{countryId}", produces = "application/json")
	public ResponseEntity<Optional<Country>> findById(
			@PathVariable("countryId") Integer countryId) {
		logger.info("# findById [instance="+instanceId+"], countryId:"+countryId);
		Optional<Country> res = serviceManager.findCountryById(countryId);
		return new ResponseEntity<Optional<Country>>(res, HttpStatus.OK);
	}
	//findByName		
	@GetMapping(value = "/findByName/{countryName}",produces = "application/json")
	public ResponseEntity<List<Country>> findByName(
			@PathVariable("countryName") String countryName) {
		logger.info("# findByName [instance="+instanceId+"], countryName:"+countryName);
		List<Country> res = serviceManager.getCountryByCountryName(countryName);
		return new ResponseEntity<List<Country>>(res, HttpStatus.OK);
	}
	//findAll		
	@GetMapping(value = "/findAll", produces = "application/json")
	public ResponseEntity<Iterable<Country>> findAll() {
		Iterable<Country> res = serviceManager.getCountryAll();		
		for (Country country : res) {
			logger.info("# findAll [instance="+instanceId+"], CountryName:"+country.getCountryName());
		}
		return new ResponseEntity<Iterable<Country>>(res, HttpStatus.OK);
	}
	//findLikeByName			 				
	@GetMapping(value = "/findLikeByName/{countryName}", produces = "application/json")
	public ResponseEntity<List<Country>> findLikeByName(
			@PathVariable("countryName") String countryName)	{
		logger.info("# findLikeByName [instance="+instanceId+"], countryName:"+countryName);
		List<Country> res = serviceManager.getCountryByCountryNameLike(countryName);
		return new ResponseEntity<List<Country>>(res, HttpStatus.OK);
	}
				
	//findLikeByNameJPQL			
	@GetMapping(value = "/findLikeByNameJPQL/{countryName}", produces = "application/json")
	public ResponseEntity<List<Country>>findLikeByNameJPQL(
			@PathVariable("countryName") String countryName) {
		logger.info("# findLikeByNameJPQL [instance="+instanceId+"], countryName:"+countryName);
		List<Country> res = serviceManager.getCountryByCountryNameJPQLLike(countryName);
		
		return new ResponseEntity<List<Country>>(res, HttpStatus.OK);
	}
				
	//deleteName				
	@GetMapping(value = "/delete/{countryName}", produces = "application/json")
	public ResponseEntity<String> deleteName(
			@PathVariable("countryName") String countryName) {
		logger.info("# deleteName [instance="+instanceId+"], countryName:"+countryName);
		serviceManager.deleteByCountryName(countryName);
		return new ResponseEntity<String>("ok", HttpStatus.OK);
	}
}
