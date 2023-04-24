package com.infina.monetaBackEnd.dataAccess.abstracts;

import com.infina.monetaBackEnd.entities.concretes.FonFiyat;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IFonFiyatData extends  JpaRepository<FonFiyat, Integer> {
 
	
} 