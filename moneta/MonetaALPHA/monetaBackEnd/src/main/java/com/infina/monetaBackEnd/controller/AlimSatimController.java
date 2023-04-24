package com.infina.monetaBackEnd.controller;

import java.util.List;

import com.infina.monetaBackEnd.business.abstracts.IAlimSatimService;
import com.infina.monetaBackEnd.entities.concretes.AlimSatim;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/alimsatim")
@RequiredArgsConstructor
public class AlimSatimController {

	
	 private static final Logger logger = LoggerFactory.getLogger(AlimSatimController.class);
	
	private final  IAlimSatimService alimSatimService;
	
	
	
	@GetMapping("/getall")
	public List<AlimSatim> getAll(){
		try {
			 logger.info("inside AlimSatimController.getAll() çalıştı.");
			return this.alimSatimService.getAll();
		} catch (Exception e) {
			logger.error("Hata : {}", e );
			String message = "An error occurred while trying to getAll AlimSatim data.";
			throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, message);
		}
	}
	
	@PostMapping("/add")
	public AlimSatim add(@RequestBody  AlimSatim alimSatim) {
		try {
			 logger.info("inside AlimSatimController.add() çalıştı.");
			return this.alimSatimService.add(alimSatim);
		} catch (Exception e) {
			logger.error("Hata : {}", e );
			String message = "An error occurred while trying to Add AlimSatim data.";
			throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, message);
		}
	}
	
	@DeleteMapping("/delete/{alimSatimId}")
	public AlimSatim delete(@PathVariable("alimSatimId") int alimSatimId ) {
		try {
			 logger.info("inside AlimSatimController.delete() çalıştı.");
			return this.alimSatimService.delete(alimSatimId);
		} catch (Exception e) {
			logger.error("Hata : {}", e );
			String message = "An error occurred while trying to delete AlimSatim data.";
			throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, message);
		}
	}
	
	@PutMapping("/update/{alimSatimId}")
	public AlimSatim update(@PathVariable("alimSatimId") int alimSatimId,@RequestBody AlimSatim alimSatim) {
		try {
			 logger.info("inside AlimSatimController.update() çalıştı.");
			return this.alimSatimService.update(alimSatimId, alimSatim);
		} catch (Exception e) {
			logger.error("Hata : {}", e );
			String message = "An error occurred while trying to update AlimSatim data.";
			throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, message);
		}
	}
}