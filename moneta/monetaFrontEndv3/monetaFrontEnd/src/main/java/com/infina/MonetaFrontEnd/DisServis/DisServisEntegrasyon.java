package com.infina.MonetaFrontEnd.DisServis;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.infina.MonetaFrontEnd.model.FonFiyatResponse;
import com.infina.MonetaFrontEnd.model.FonTanimiResponse;
import com.infina.MonetaFrontEnd.model.HavaleProvizyonResponse;
import com.infina.MonetaFrontEnd.model.MusteriResponse;
import com.infina.MonetaFrontEnd.model.PersonelResponse;

public interface DisServisEntegrasyon {
	
	public static final String SERVICE_NAME = "DisServisEntegrasyon";
	public List<PersonelResponse> getAllPersonel ();
	public List <FonTanimiResponse> getAllFon();
	public List <HavaleProvizyonResponse> getAllHavaleProvizyon();
	public List <MusteriResponse> getAllMusteri();
	public List <FonFiyatResponse> getAllFonFiyat();
	
	
	//-----------------------------------------
	public HavaleProvizyonResponse deleteHavaleProvizyon(int HavaleProvizyonResponseID);
	public HavaleProvizyonResponse addHavaleProvizyon(HavaleProvizyonResponse HProv);
	public MusteriResponse addMusteriList (MusteriResponse Musteri);
	public FonFiyatResponse addFonFiyat(FonFiyatResponse fonFiyat);
	public FonFiyatResponse deleteFonFiyat(int fonFiyatId);
}
