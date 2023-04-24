package com.infina.monetaBackEnd.business.abstracts;

import java.util.List;

import com.infina.monetaBackEnd.entities.concretes.FonFiyat;

public interface IFonFiyatService {

	
	List<FonFiyat> getAll();
	
	FonFiyat add(FonFiyat fonFiyat);
	
	FonFiyat delete(int fonFiyatId);
	
	FonFiyat update(int fonFiyatId, FonFiyat fonFiyat);
}
