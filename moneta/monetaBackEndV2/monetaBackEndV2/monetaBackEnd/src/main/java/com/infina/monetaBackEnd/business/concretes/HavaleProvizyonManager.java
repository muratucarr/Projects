package com.infina.monetaBackEnd.business.concretes;

import java.util.List;

import com.infina.monetaBackEnd.business.abstracts.IHavaleProvizyon;
import com.infina.monetaBackEnd.dataAccess.abstracts.IHavale_ProvizyonData;
import com.infina.monetaBackEnd.entities.concretes.HavaleProvizyon;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class HavaleProvizyonManager implements IHavaleProvizyon {

    private final IHavale_ProvizyonData havaleProvizyonData;
	
	@Override
	public List<HavaleProvizyon> getAll() {
	   return this.havaleProvizyonData.findAll();
	}

	@Override
	public HavaleProvizyon add(HavaleProvizyon havaleProvizyon) {
		 return this.havaleProvizyonData.save(havaleProvizyon);
	}

	@Override
	public HavaleProvizyon update(int havaleProvizyonId, HavaleProvizyon havaleProvizyon) {
		 HavaleProvizyon db = this.havaleProvizyonData.findById(havaleProvizyonId).get();
		 db.setBakiye(havaleProvizyon.getBakiye());
		 db.setIslemTipi(havaleProvizyon.getIslemTipi());
		 db.setMusteri_portfoyNo(havaleProvizyon.getMusteri_portfoyNo());
		 db.setIslemTutari(havaleProvizyon.getIslemTutari());
		 db.setTarih(havaleProvizyon.getTarih());
		 return this.havaleProvizyonData.save(db);
	}

	@Override
	public HavaleProvizyon delete(int havaleProvizyonId) {
		 HavaleProvizyon db = this.havaleProvizyonData.findById(havaleProvizyonId).get();
		 this.havaleProvizyonData.delete(db);
		 return db;
	}

}
