package com.infina.monetaBackEnd.controller;



import java.util.List;
 

import com.infina.monetaBackEnd.business.abstracts.IPersonelService;
import com.infina.monetaBackEnd.entities.concretes.Personel;

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
@RequestMapping("/api/personel")
public class PersonelController {
  
	private final IPersonelService IpersonelService;

	
	@GetMapping("/getall")
	public List<Personel> getAll(){
		
		try {
			return this.IpersonelService.getAll();
		}catch(Exception e) {
			String message = "An error occurred while trying to getAll personel data.";
			 throw new  ResponseStatusException(HttpStatus.BAD_REQUEST, message);
		}
	}
	
	
	@PostMapping("/add")
	public Personel add(@RequestBody Personel personel) {
		try {
				return this.IpersonelService.add(personel);
		}catch (Exception e) {
		   String message = "An error occurred while trying to save Personel data";
		   throw new ResponseStatusException(HttpStatus.BAD_REQUEST,message);
		}
	
		
	}
		
	 
   @PutMapping("/update/{id}")
   public Personel update(@PathVariable("id") int id ,@RequestBody Personel personel) {
	   try {
		   return this.IpersonelService.update(id, personel);
		   
	   }catch (Exception e) {
		   String message = "An error occurred while trying to update Personel data";
		   throw new ResponseStatusException(HttpStatus.BAD_REQUEST,message);
	}
   }
    
	
	@DeleteMapping("delete/{id}")
	public Personel delete(@PathVariable("id") int id ) {
		
		try {
			return this.IpersonelService.delete(id);
		} catch (Exception e) {
			String message = "An error occurred while trying to Delete Personel data";
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, message);
		}
		
	}
	
	
	
 
 
	
}