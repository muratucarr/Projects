package com.infina.monetaBackEnd.business.abstracts;

import java.util.List;

import com.infina.monetaBackEnd.entities.concretes.Musteri;

public interface IMusteriService {
     
	List<Musteri> getAll();
	
	Musteri add(Musteri musteri);
	
	Musteri delete(int id );
	
	Musteri update(int id , Musteri musteri);

}
