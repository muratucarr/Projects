package com.infina.monetaBackEnd.business.concretes;

import java.util.List;

import com.infina.monetaBackEnd.business.abstracts.IAlimSatimService;
import com.infina.monetaBackEnd.dataAccess.abstracts.IAlimSatimData;
import com.infina.monetaBackEnd.entities.concretes.AlimSatim;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlimSatimManager implements IAlimSatimService {

	private final IAlimSatimData alimSatimData;
	
	@Override
	public List<AlimSatim> getAll() {
		return this.alimSatimData.findAll();
	}

	@Override
	public AlimSatim add(AlimSatim alimSatim) {
          
		return this.alimSatimData.save(alimSatim);
  
	}

	@Override
	public AlimSatim delete(int alimSatimId) {
		 AlimSatim db = this.alimSatimData.findById(alimSatimId).get();
		 this.alimSatimData.delete(db);
		 return db;
	}

	@Override
	public AlimSatim update(int alimSatimId, AlimSatim alimSatim) {
	   AlimSatim db = this.alimSatimData.findById(alimSatimId).get();
	   db.setTutar(alimSatim.getTutar());
	   db.setFiyat(alimSatim.getFiyat());
	   db.setFon_fonKodu(alimSatim.getFon_fonKodu());
	   db.setIslemTarihi(alimSatim.getIslemTarihi());
	   db.setIslemTipi(alimSatim.getIslemTipi());
	   db.setMusteri_portfoyNo(alimSatim.getMusteri_portfoyNo());
	   db.setStok(alimSatim.getStok());
	   db.setMiktar(alimSatim.getStok());
	  return  this.alimSatimData.save(db);
	   
	}

}
