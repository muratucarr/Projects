package com.infina.MonetaFrontEnd.DisServis;

import java.util.List;

import com.infina.MonetaFrontEnd.model.PersonelResponse;

public interface DisServisEntegrasyon {
	
	public static final String SERVICE_NAME = "DisServisEntegrasyon";
	public List<PersonelResponse> getAllPersonel ();
	public void Deneme();
}
