package com.infina.monetaBackEnd.business.abstracts;

import java.util.List;

import com.infina.monetaBackEnd.entities.concretes.HavaleProvizyon;

public interface IHavaleProvizyon {

	
	List<HavaleProvizyon> getAll();
	
	HavaleProvizyon add(HavaleProvizyon havaleProvizyon);
	
	HavaleProvizyon update(int havaleProvizyonId ,HavaleProvizyon havaleProvizyon);
	
	HavaleProvizyon delete(int havaleProvizyonId);
	
}
