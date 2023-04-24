package com.infina.monetaBackEnd.business.concretes;

import java.util.List;

import com.infina.monetaBackEnd.business.abstracts.IFonService;
import com.infina.monetaBackEnd.dataAccess.abstracts.IFonData;
import com.infina.monetaBackEnd.entities.concretes.Fon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FonManager implements IFonService {

	
	private static final Logger logger = LoggerFactory.getLogger(FonManager.class);
	private final IFonData fonData;
	
	@Override
	public List<Fon> getAll() {
		  logger.info("FonManager getAll() çalıştı.");
	   return this.fonData.findAll();
	}

	@Override
	public Fon add(Fon fon) {
		  logger.info("FonManager add() çalıştı.");
		  this.fonData.save(fon);
		  return fon ;
	}

 

 
	@Override
	public Fon delete(String fonKodu) {
		  logger.info("FonManager delete() çalıştı.");
		 Fon db = this.fonData.findById(fonKodu).get();
		 this.fonData.delete(db);
		 return db;
	}

	@Override
	public Fon update(String fonKodu, Fon fon) {
		  logger.info("FonManager update() çalıştı.");
		 Fon db = this.fonData.findById(fonKodu).get();
		 db.setFonAdi(fon.getFonAdi());
		 db.setFonKodu(fon.getFonKodu());
		 db.setIsinKodu(fon.getIsinKodu());
		 return this.fonData.save(db);
	 
	}

	
}
