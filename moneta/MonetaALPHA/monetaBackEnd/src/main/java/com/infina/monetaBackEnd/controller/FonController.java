package com.infina.monetaBackEnd.controller;

import java.util.List;

import com.infina.monetaBackEnd.business.abstracts.IFonService;
import com.infina.monetaBackEnd.entities.concretes.Fon;

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


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/fon")
public class FonController {
  
	 private static final Logger logger = LoggerFactory.getLogger(FonController.class);
	
	private final IFonService fonService;
	
	
	@GetMapping("/getAll")
	public List<Fon> getAll(){
		try {
			logger.info("inside FonController.getAll() çalıştı.");
			return this.fonService.getAll();
		}catch (Exception e) {
			logger.error("Hata : {}", e );
			String message = "An error occurred while trying to get Fon data.";
			throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, message);
		}
	}
	
	@PostMapping("/add")
	public Fon add(@RequestBody Fon fon) {
		try {
			logger.info("inside FonController.add() çalıştı.");
		  return this.fonService.add(fon);
		}catch (Exception e) {
			logger.error("Hata : {}", e );
			String message = "An error occurred while trying to add Fon data.";
			throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, message);
		}
	}
	
	@PutMapping("/update/{fonKodu}")
	public  Fon update(@PathVariable("fonKodu") String fonKodu , @RequestBody Fon fon){
		try {
			logger.info("inside FonController.update() çalıştı.");
			return this.fonService.update(fonKodu, fon);
		} catch (Exception e) {
			logger.error("Hata : {}", e );
			String message = "An error occurred while trying to update Fon data.";
			throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, message);
		}
	}
	
	@DeleteMapping("/delete/{fonKodu}")
	public Fon delete(@PathVariable("fonKodu") String fonKodu) {
		try {
			logger.info("inside FonController.delete() çalıştı.");
		  return 	this.fonService.delete(fonKodu);
		} catch (Exception e) {
			logger.error("Hata : {}", e );
			String message = "An error occurred while trying to update Fon data.";
			throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, message);
		}
	}
	
	 
	
}