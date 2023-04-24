package com.infina.monetaBackEnd.business.concretes;

import java.util.List;

import com.infina.monetaBackEnd.business.abstracts.IFonFiyatService;
import com.infina.monetaBackEnd.dataAccess.abstracts.IFonFiyatData;
 
import com.infina.monetaBackEnd.entities.concretes.FonFiyat;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FonFiyatManager  implements IFonFiyatService{

	private final IFonFiyatData fonFiyatData;

	@Override
	public List<FonFiyat> getAll() {
		return this.fonFiyatData.findAll();
	}

	@Override
	public FonFiyat add(FonFiyat fonFiyat) {
		 return this.fonFiyatData.save(fonFiyat);
	}

	@Override
	public FonFiyat delete(int fonFiyatId) {
		 FonFiyat db = this.fonFiyatData.findById(fonFiyatId).get();
		 this.fonFiyatData.delete(db);
		 return db ;
	}

	@Override
	public FonFiyat update(int fonFiyatId, FonFiyat fonFiyat) {
		FonFiyat db = this.fonFiyatData.findById(fonFiyatId).get();
		db.setFonFiyatId(fonFiyat.getFonFiyatId());
		db.setFiyat(fonFiyat.getFiyat());
		db.setFon_FonKodu(fonFiyat.getFon_FonKodu());
		db.setTarih(fonFiyat.getTarih());
		 return this.fonFiyatData.save(db);
	}

 
	 

}
