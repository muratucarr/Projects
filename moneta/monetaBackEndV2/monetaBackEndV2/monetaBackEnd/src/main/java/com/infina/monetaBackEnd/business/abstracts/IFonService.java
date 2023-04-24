package com.infina.monetaBackEnd.business.abstracts;

import java.util.List;

import com.infina.monetaBackEnd.entities.concretes.Fon;

public interface IFonService {

	    
	  List<Fon> getAll();
	  
	  Fon add(Fon fon);
	  
	  Fon update(String  fonKodu , Fon fon);
	  
	  Fon delete(String fonKodu );
}
