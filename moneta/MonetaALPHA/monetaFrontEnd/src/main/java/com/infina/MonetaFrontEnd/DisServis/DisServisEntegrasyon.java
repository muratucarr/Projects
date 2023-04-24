package com.infina.MonetaFrontEnd.DisServis;

import java.util.List;

import com.infina.MonetaFrontEnd.model.FonAlimSatimResponse;
import com.infina.MonetaFrontEnd.model.FonFiyatResponse;
import com.infina.MonetaFrontEnd.model.FonTanimiResponse;
import com.infina.MonetaFrontEnd.model.HavaleProvizyonResponse;
import com.infina.MonetaFrontEnd.model.MusteriResponse;
import com.infina.MonetaFrontEnd.model.PersonelResponse;

public interface DisServisEntegrasyon {
	
	public static final String SERVICE_NAME = "DisServisEntegrasyon";

	
	
	
	
	
	//---------------------PERSONEL---------------------
	public List<PersonelResponse> getAllPersonel ();
	//----------------------MUSTERI-------------------
	public List <MusteriResponse> getAllMusteri();
	public MusteriResponse updateMusteri (int portfoyNo , MusteriResponse musteri);
	public MusteriResponse addMusteriList (MusteriResponse Musteri);
	//----------------------FON FİYAT------------------
	public List <FonFiyatResponse> getAllFonFiyat();
	public FonFiyatResponse addFonFiyat(FonFiyatResponse fonFiyat);
	public FonFiyatResponse deleteFonFiyat(int fonFiyatId);
	//---------------------HAVALE-PROVİZYON-------------
	public List <HavaleProvizyonResponse> getAllHavaleProvizyon();
	public HavaleProvizyonResponse deleteHavaleProvizyon(int HavaleProvizyonResponseID);
	public HavaleProvizyonResponse addHavaleProvizyon(HavaleProvizyonResponse HProv);
	//--------------------FON ALIM-SATIM-----------------
	public FonAlimSatimResponse addFonAlimSatim(FonAlimSatimResponse fonAlimSatim);
	public List <FonAlimSatimResponse> getAllAlimSatim();
	public FonAlimSatimResponse updateFonAlimSatim(int alimSatimId , FonAlimSatimResponse fonAlimSatim);
	//--------------------FON TANIMI----------------------
	public FonTanimiResponse addFonTanimi(FonTanimiResponse fonTanimi);
	public List <FonTanimiResponse> getAllFon();
	
	
}
