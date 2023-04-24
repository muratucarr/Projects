package com.infina.monetaBackEnd.dataAccess.abstracts;

import com.infina.monetaBackEnd.entities.concretes.Fon;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IFonData extends  JpaRepository<Fon, String> {
//	Fon findFonById(String id);
	
} 