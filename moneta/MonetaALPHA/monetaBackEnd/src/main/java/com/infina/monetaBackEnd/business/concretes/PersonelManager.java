package com.infina.monetaBackEnd.business.concretes;

import java.util.List;

import com.infina.monetaBackEnd.business.abstracts.IPersonelService;
import com.infina.monetaBackEnd.dataAccess.abstracts.IPersonelData;
import com.infina.monetaBackEnd.entities.concretes.Personel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
 

@Service
@RequiredArgsConstructor
public class PersonelManager  implements IPersonelService {

	
	private static final Logger logger = LoggerFactory.getLogger(PersonelManager.class);
	
  private final IPersonelData  personelData;

  	
  
	@Override
	public List<Personel> getAll() {
		  logger.info("PersonelManager getAll() çalıştı.");
		 return personelData.findAll();
	}

	@Override
	public Personel add(Personel personel) {
		 logger.info("PersonelManager Add() çalıştı.");
		 return this.personelData.save(personel);
		
	}

	@Override
	public Personel update(int id, Personel personel) {
		 logger.info("PersonelManager Update() çalıştı.");
		 Personel db = this.personelData.findById(id).get();
		 db.setAd(personel.getAd());
		 db.setSoyad(personel.getSoyad());
		 db.setKullaniciAdi(personel.getKullaniciAdi());
		 db.setSifre(personel.getSifre());
		 return this.personelData.save(db);
		 
		 
	}

	@Override
	public Personel delete(int id ) {
		 logger.info("PersonelManager delete() çalıştı.");
		Personel db = this.personelData.findById(id).get();
		this.personelData.deleteById(id);
		return db;
		 
	}

}