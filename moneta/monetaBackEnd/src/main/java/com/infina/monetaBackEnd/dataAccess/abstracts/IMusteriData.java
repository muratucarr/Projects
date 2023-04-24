package com.infina.monetaBackEnd.dataAccess.abstracts;

import com.infina.monetaBackEnd.entities.concretes.Musteri;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IMusteriData extends  JpaRepository<Musteri, Integer> {
	//Musteri findMusteriById(Integer id);
	
} 