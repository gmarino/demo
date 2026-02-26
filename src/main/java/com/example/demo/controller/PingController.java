package com.example.demo.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.exception.DuplicateException;
import com.example.demo.exception.ResourceNotFoundException;

@Controller
@RequestMapping("/api/pingctrl")
public class PingController {
	
	private static final Logger logger = LoggerFactory.getLogger(PingController.class);
	
	@Value("${message}")
	private String message;
	
	@Value("${server.instance.id}")
	private String instanceId;

	@GetMapping("/pingTst")
	@ResponseBody
	public String pingTst() {
		String msg = "instance="+instanceId+", pingTst";
		logger.info(msg);
		return (msg);
	}
	
	@GetMapping("/ping")
	@ResponseBody
	public String ping() {
		Date myDate = new Date();
		String msg = "instance="+instanceId+", message"+": "+myDate;
		logger.info(msg);
		return msg;
	}
	
	@GetMapping(value = "/ping-dex", produces = "application/json")
	public ResponseEntity<String> pingDuplicateException() throws DuplicateException{
		String msg = "### "+"instance="+instanceId+", PingCtrl.pingDuplicateException";
		logger.info(msg);
		
		throw new DuplicateException();
		//return new ResponseEntity<String> ("Can't reach", HttpStatus.NOT_ACCEPTABLE);
	}

	@GetMapping(value = "/ping-rnfex", produces = "application/json")
	public ResponseEntity<String> pingResourceNotFoundException() throws ResourceNotFoundException{
		String msg = "### "+"instance="+instanceId+", PingCtrl.pingResourceNotFoundException";
		logger.info(msg);
		
		throw new ResourceNotFoundException();
		//return new ResponseEntity<String> ("Can't reach", HttpStatus.NOT_ACCEPTABLE);
	}
}
