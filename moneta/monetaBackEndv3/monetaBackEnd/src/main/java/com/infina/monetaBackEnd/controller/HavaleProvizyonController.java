package com.infina.monetaBackEnd.controller;

import java.util.List;

import com.infina.monetaBackEnd.business.abstracts.IHavaleProvizyon;
import com.infina.monetaBackEnd.entities.concretes.HavaleProvizyon;
 

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
@RequiredArgsConstructor
@RequestMapping("/api/havaleprovizyon")
public class HavaleProvizyonController {

	private final IHavaleProvizyon havaleProvizyon;

	@GetMapping("/getall")
	public List<HavaleProvizyon> getAll() {
		try {
			return this.havaleProvizyon.getAll();
		} catch (Exception e) {
			String message = "An error occurred while trying to getAll HavaleProvizyon data.";
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, message);
		}
	}
	
	@PostMapping("/add")
	public HavaleProvizyon add(@RequestBody HavaleProvizyon havaleProvizyon) {
		try {
				return this.havaleProvizyon.add(havaleProvizyon);
		}catch (Exception e) {
		   String message = "An error occurred while trying to save Personel data";
		   throw new ResponseStatusException(HttpStatus.BAD_REQUEST,message);
		}
	
		
	}
		
	 
	
	@PutMapping("/update/{havaleProvizyonId}")
	public HavaleProvizyon update(@PathVariable("havaleProvizyonId") int havaleProvizyonId , @RequestBody HavaleProvizyon havaleProvizyon) {
		try {
			return this.havaleProvizyon.update(havaleProvizyonId, havaleProvizyon);
		} catch (Exception e) {
			String message = "An error occurred while trying to update HavaleProvizyon data.";
			 throw new  ResponseStatusException(HttpStatus.BAD_REQUEST, message);
		}
		
	}
	
	@DeleteMapping("/delete/{havaleProvizyonId}")
	public HavaleProvizyon delete(@PathVariable("havaleProvizyonId") int havaleProvizyonId) {
		try {
			return this.havaleProvizyon.delete(havaleProvizyonId);
		} catch (Exception e) {
			String message = "HavaleProvizyon Silme İşlemi Yapılırken Bir Hata Meydana Geldi";
			 throw new  ResponseStatusException(HttpStatus.BAD_REQUEST, message);
		}
	}
	
	
	
	
	
	
	
	
	
	

}
