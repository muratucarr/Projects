package com.infina.monetaBackEnd.business.abstracts;

import java.util.List;

import com.infina.monetaBackEnd.entities.concretes.AlimSatim;

public interface IAlimSatimService {
   
	List<AlimSatim> getAll();
	
	AlimSatim add(AlimSatim alimSatim);
	
	AlimSatim delete(int alimSatimId);
	
	AlimSatim update(int alimSatimId , AlimSatim alimSatim );
	
}
