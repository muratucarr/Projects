package com.infina.monetaBackEnd.business.concretes;

import java.util.List;

import com.infina.monetaBackEnd.business.abstracts.IFonFiyatService;
import com.infina.monetaBackEnd.dataAccess.abstracts.IFonFiyatData;
 
import com.infina.monetaBackEnd.entities.concretes.FonFiyat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FonFiyatManager  implements IFonFiyatService{

	
	private static final Logger logger = LoggerFactory.getLogger(FonFiyatManager.class);
	
	private final IFonFiyatData fonFiyatData;

	@Override
	public List<FonFiyat> getAll() {
		 logger.info("FonFiyatManager getAll() çalıştı.");
		return this.fonFiyatData.findAll();
	}

	@Override
	public FonFiyat add(FonFiyat fonFiyat) {
		logger.info("FonFiyatManager add() çalıştı.");
		 return this.fonFiyatData.save(fonFiyat);
	}

	@Override
	public FonFiyat delete(int fonFiyatId) {
		logger.info("FonFiyatManager delete() çalıştı.");
		 FonFiyat db = this.fonFiyatData.findById(fonFiyatId).get();
		 this.fonFiyatData.delete(db);
		 return db ;
	}

	@Override
	public FonFiyat update(int fonFiyatId, FonFiyat fonFiyat) {
		logger.info("FonFiyatManager update() çalıştı.");
		FonFiyat db = this.fonFiyatData.findById(fonFiyatId).get();
		db.setFonFiyatId(fonFiyat.getFonFiyatId());
		db.setFiyat(fonFiyat.getFiyat());
		db.setFon_FonKodu(fonFiyat.getFon_FonKodu());
		db.setTarih(fonFiyat.getTarih());
		 return this.fonFiyatData.save(db);
	}

 
	 

}