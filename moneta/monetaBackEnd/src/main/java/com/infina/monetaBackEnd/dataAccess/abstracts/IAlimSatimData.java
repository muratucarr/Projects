package com.infina.monetaBackEnd.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infina.monetaBackEnd.entities.concretes.AlimSatim;


public interface IAlimSatimData  extends  JpaRepository<AlimSatim, Integer> {
//	AlimSatim findAlimSatimlById(Integer id);
	
} 
