package com.infina.monetaBackEnd.business.concretes;

import java.util.List;

import com.infina.monetaBackEnd.business.abstracts.IPersonelService;
import com.infina.monetaBackEnd.dataAccess.abstracts.IPersonelData;
import com.infina.monetaBackEnd.entities.concretes.Personel;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
 

@Service
@RequiredArgsConstructor
public class PersonelManager  implements IPersonelService {

  private final IPersonelData  personelData;

  	
  
	@Override
	public List<Personel> getAll() {
		 return personelData.findAll();
	}



	@Override
	public void savePersonel(Personel yeniPersonel) {
		this.personelData.save(yeniPersonel);
	}

}