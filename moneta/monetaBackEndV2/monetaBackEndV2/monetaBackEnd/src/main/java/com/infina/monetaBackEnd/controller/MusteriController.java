package com.infina.monetaBackEnd.controller;

import java.util.List;

import com.infina.monetaBackEnd.business.abstracts.IMusteriService;
import com.infina.monetaBackEnd.entities.concretes.Musteri;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/musteri")
public class MusteriController {

	private final IMusteriService musteriService;

	@GetMapping("/getAll")
	public List<Musteri> getAll() {
		try {
			return this.musteriService.getAll();
		} catch (Exception e) {

			String message = "An error occurred while trying to getAll personel data.";
			throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, message);
		}
	}

	@PostMapping("/add")
	public Musteri add(@RequestBody Musteri musteri) {

		try {
			return this.musteriService.add(musteri);
		} catch (Exception e) {

			String message = "An error occurred while trying to add Musteri data.";
			throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, message);
		}

	}
	
	@PutMapping("/update/{portfoyNo}")
	public  Musteri update(@PathVariable("portfoyNo") int portfoyNo , @RequestBody Musteri musteri) {
		
		try {
		  return 	this.musteriService.update(portfoyNo, musteri);
		} catch (Exception e) {
			String message = "An error occurred while trying to update Musteri data.";
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY,message);
		}
	}
	
	@DeleteMapping("/delete/{portfoyNo}")
	public Musteri delete(@PathVariable("portfoyNo") int portfoyNo ) {
		
	   return	this.musteriService.delete(portfoyNo);
	  
	}
	
	
}
