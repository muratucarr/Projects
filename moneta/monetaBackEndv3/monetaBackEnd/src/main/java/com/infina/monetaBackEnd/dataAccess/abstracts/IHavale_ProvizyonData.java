package com.infina.monetaBackEnd.dataAccess.abstracts;

import com.infina.monetaBackEnd.entities.concretes.HavaleProvizyon;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IHavale_ProvizyonData extends  JpaRepository<HavaleProvizyon, Integer> {
 
	
	
} 