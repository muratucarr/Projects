package com.infina.monetaBackEnd.business.concretes;

import java.util.List;

import com.infina.monetaBackEnd.business.abstracts.IHavaleProvizyon;
import com.infina.monetaBackEnd.dataAccess.abstracts.IHavale_ProvizyonData;
import com.infina.monetaBackEnd.entities.concretes.HavaleProvizyon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class HavaleProvizyonManager implements IHavaleProvizyon {

	private static final Logger logger = LoggerFactory.getLogger(PersonelManager.class);
	
    private final IHavale_ProvizyonData havaleProvizyonData;
	
	@Override
	public List<HavaleProvizyon> getAll() {
		logger.info("HavaleProvizyonManager getAll() çalıştı.");
	   return this.havaleProvizyonData.findAll();
	}

	@Override
	public HavaleProvizyon add(HavaleProvizyon havaleProvizyon) {
		logger.info("HavaleProvizyonManager add() çalıştı.");
		 return this.havaleProvizyonData.save(havaleProvizyon);
	}

	@Override
	public HavaleProvizyon update(int havaleProvizyonId, HavaleProvizyon havaleProvizyon) {
		logger.info("HavaleProvizyonManager update() çalıştı.");
		 HavaleProvizyon db = this.havaleProvizyonData.findById(havaleProvizyonId).get();
		 db.setIslemTipi(havaleProvizyon.getIslemTipi());
		 db.setMusteri_portfoyNo(havaleProvizyon.getMusteri_portfoyNo());
		 db.setIslemTutari(havaleProvizyon.getIslemTutari());
		 db.setTarih(havaleProvizyon.getTarih());
		 return this.havaleProvizyonData.save(db);
	}

	@Override
	public HavaleProvizyon delete(int havaleProvizyonId) {
		logger.info("HavaleProvizyonManager delete() çalıştı.");
		 HavaleProvizyon db = this.havaleProvizyonData.findById(havaleProvizyonId).get();
		 this.havaleProvizyonData.delete(db);
		 return db;
	}

}