package com.infina.MonetaFrontEnd.model;

import java.io.Serializable;
import java.util.Date;

public class FonAlimSatimResponse  implements Serializable{

	
	private static final long serialVersionUID = 8707365477530485639L;
	
	private int alimSatimId;
	
	private MusteriResponse musteri_portfoyNo;
	private FonTanimiResponse fon_fonKodu;
	
	private Date islemTarihi;
	private String islemTipi;
	
	private String silindiMi;
	
	private double miktar;
	private double stok;
	
	private double fiyat;
	private double tutar;
	
	public FonAlimSatimResponse()
	{
		this.musteri_portfoyNo = new MusteriResponse();
		this.fon_fonKodu = new FonTanimiResponse();
	}
	
	
	public MusteriResponse getMusteri_portfoyNo() {
		return musteri_portfoyNo;
	}
	public void setMusteri_portfoyNo(MusteriResponse musteri_portfoyNo) {
		this.musteri_portfoyNo = musteri_portfoyNo;
	}
	public FonTanimiResponse getFon_fonKodu() {
		return fon_fonKodu;
	}
	public void setFon_fonKodu(FonTanimiResponse fon_fonKodu) {
		this.fon_fonKodu = fon_fonKodu;
	}
	public Date getIslemTarihi() {
		return islemTarihi;
	}
	public void setIslemTarihi(Date islemTarihi) {
		this.islemTarihi = islemTarihi;
	}
	public String getIslemTipi() {
		return islemTipi;
	}
	public void setIslemTipi(String islemTipi) {
		this.islemTipi = islemTipi;
	}


	public double getMiktar() {
		return miktar;
	}


	public void setMiktar(double miktar) {
		this.miktar = miktar;
	}


	public double getStok() {
		return stok;
	}


	public void setStok(double stok) {
		this.stok = stok;
	}


	public double getFiyat() {
		return fiyat;
	}


	public void setFiyat(double fiyat) {
		this.fiyat = fiyat;
	}


	public double getTutar() {
		return tutar;
	}


	public void setTutar(double tutar) {
		this.tutar = tutar;
	}


	public int getAlimSatimId() {
		return alimSatimId;
	}


	public void setAlimSatimId(int alimSatimId) {
		this.alimSatimId = alimSatimId;
	}


	public String getSilindiMi() {
		return silindiMi;
	}


	public void setSilindiMi(String silindiMi) {
		this.silindiMi = silindiMi;
	}

	
	
	
	

}