package com.infina.monetaBackEnd.business.concretes;

import java.util.List;

import com.infina.monetaBackEnd.business.abstracts.IMusteriService;
import com.infina.monetaBackEnd.dataAccess.abstracts.IMusteriData;
import com.infina.monetaBackEnd.entities.concretes.Musteri;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MusteriManager implements IMusteriService {

	private final IMusteriData musteriData;
	
	
	@Override
	public List<Musteri> getAll() {
	   return this.musteriData.findAll();
	}


	@Override
	public Musteri add(Musteri musteri) {
		 this.musteriData.save(musteri);
		 return musteri;
		 
	}


	@Override
	public Musteri delete(int id) {
	   Musteri db = this.musteriData.findById(id).get();
	   this.musteriData.delete(db);
	   return db;
	   
	}


	@Override
	public Musteri update(int id, Musteri musteri) {
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
