package com.infina.monetaBackEnd.business.concretes;

import java.util.List;

import com.infina.monetaBackEnd.business.abstracts.IMusteriService;
import com.infina.monetaBackEnd.dataAccess.abstracts.IMusteriData;
import com.infina.monetaBackEnd.entities.concretes.Musteri;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MusteriManager implements IMusteriService {

	
	private static final Logger logger = LoggerFactory.getLogger(MusteriManager.class);
	
	private final IMusteriData musteriData;
	
	
	@Override
	public List<Musteri> getAll() {
		 logger.info("MusteriManager getAll() çalıştı.");
	   return this.musteriData.findAll();
	}


	@Override
	public Musteri add(Musteri musteri) {
		 logger.info("MusteriManager add() çalıştı.");
		 this.musteriData.save(musteri);
		 return musteri;
		 
	}


	@Override
	public Musteri delete(int id) {
		 logger.info("MusteriManager delete() çalıştı.");
	   Musteri db = this.musteriData.findById(id).get();
	   this.musteriData.delete(db);
	   return db;
	   
	}


	@Override
	public Musteri update(int id, Musteri musteri) {
		 logger.info("MusteriManager update() çalıştı.");
		Musteri db = this.musteriData.findById(id).get(); 
		db.setAd(musteri.getAd());
		db.setSoyad(musteri.getSoyad());
		db.setTcNo(musteri.getTcNo());
		db.setYerlesimBelgesi(musteri.getYerlesimBelgesi());
		db.setPortfoyNo(musteri.getPortfoyNo());
		db.setBakiye(musteri.getBakiye());
	  return  this.musteriData.save(db);
		 
	}



 

}