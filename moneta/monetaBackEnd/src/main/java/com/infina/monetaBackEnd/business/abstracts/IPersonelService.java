package com.infina.monetaBackEnd.business.abstracts;

import java.util.List;

import com.infina.monetaBackEnd.entities.concretes.Personel;

public interface IPersonelService {
  
	 List<Personel> getAll();
		
	 public void savePersonel(Personel yeniPersonel);
		  
}