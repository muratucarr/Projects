package com.infina.monetaBackEnd.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infina.monetaBackEnd.entities.concretes.Personel;

public interface IPersonelData  extends  JpaRepository<Personel, Integer> {
	Personel findBypersonelId(Integer id);
	
} 
