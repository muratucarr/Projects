package com.infina.monetaBackEnd.controller;

import java.util.List;

import com.infina.monetaBackEnd.business.abstracts.IFonFiyatService;
import com.infina.monetaBackEnd.entities.concretes.FonFiyat;

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
@RequestMapping("/api/FonFiyat")
public class FonFiyatController {

	private final IFonFiyatService fonFiyatService;

	@GetMapping("/getAll")
	public List<FonFiyat> getAll() {
		try {
			return this.fonFiyatService.getAll();
		} catch (Exception e) {

			String message = "An error occurred while trying to getAll Fonfiyat data.";
			throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, message);
		}
	}
	
	
	@PostMapping("/add")
	public FonFiyat add(@RequestBody FonFiyat fonFiyat) {
		try {
			return this.fonFiyatService.add(fonFiyat);
		}catch (Exception e) {
			String message = "An error occurred while trying to add Fonfiyat data.";
			throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, message);
		}
	}
	
	@PutMapping("/update/{fonFiyatId}")
	public FonFiyat update(@PathVariable("fonFiyatId") int fonFiyatId , @RequestBody FonFiyat fonFiyat) {
		try {
			return this.fonFiyatService.update(fonFiyatId, fonFiyat);
		} catch (Exception e) {
			String message = "An error occurred while trying to update Fonfiyat data.";
			throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, message);
		}
	}
	
	@DeleteMapping("/delete/{fonFiyatId}")
	public FonFiyat delete(@PathVariable("fonFiyatId") int fonFiyatId ) {
		try {
			return this.fonFiyatService.delete(fonFiyatId);
		} catch (Exception e) {
			String message = "An error occurred while trying to delete Fonfiyat data.";
			throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, message);
		}
	}
}
