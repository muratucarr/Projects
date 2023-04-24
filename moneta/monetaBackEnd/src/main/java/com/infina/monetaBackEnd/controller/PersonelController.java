package com.infina.monetaBackEnd.controller;



import java.util.List;

import com.infina.monetaBackEnd.business.abstracts.IPersonelService;
import com.infina.monetaBackEnd.entities.concretes.Personel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/personel")
public class PersonelController {
  
	private final IPersonelService IpersonelService;

	
	@GetMapping("/getall")
	public List<Personel> getAll(){
		return IpersonelService.getAll();
	}
	
	@PostMapping("/createpersonel")
	public void createPersonel(@RequestBody Personel yeniPersonel) {
		
		this.IpersonelService.savePersonel(yeniPersonel);
		// kaydedebildiği -- kaydedemediği durum
	}
	
	
}