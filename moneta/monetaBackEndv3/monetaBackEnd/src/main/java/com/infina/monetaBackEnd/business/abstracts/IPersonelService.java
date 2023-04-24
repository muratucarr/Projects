package com.infina.monetaBackEnd.business.abstracts;

import java.util.List;

import com.infina.monetaBackEnd.entities.concretes.Personel;

public interface IPersonelService {
  
	 List<Personel> getAll();
	   
	 
	  Personel add(Personel Personel);
	 
	 Personel update(int id , Personel personel);
	 
	 Personel delete(int id );
		  
}