package com.infina.MonetaFrontEnd.model;

import java.util.Date;

public class FonFiyatResponse {
	
	
	private int fonFiyatId;
	private Date tarih;
	private double fiyat;
	private FonTanimiResponse fon_FonKodu;
	
	public FonFiyatResponse()
	{
		fon_FonKodu = new FonTanimiResponse();
	}
	
	public int getFonFiyatId() {
		return fonFiyatId;
	}
	public void setFonFiyatId(int fonFiyatId) {
		this.fonFiyatId = fonFiyatId;
	}
	public Date getTarih() {
		return tarih;
	}
	public void setTarih(Date tarih) {
		this.tarih = tarih;
	}
	public double getFiyat() {
		return fiyat;
	}
	public void setFiyat(double fiyat) {
		this.fiyat = fiyat;
	}
	public FonTanimiResponse getFon_FonKodu() {
		return fon_FonKodu;
	}
	public void setFon_FonKodu(FonTanimiResponse fon_FonKodu) {
		this.fon_FonKodu = fon_FonKodu;
	}

}