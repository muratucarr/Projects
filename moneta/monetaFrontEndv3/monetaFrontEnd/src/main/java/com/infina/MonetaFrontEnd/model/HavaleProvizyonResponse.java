package com.infina.MonetaFrontEnd.model;

import java.io.Serializable;
import java.util.Date;

public class HavaleProvizyonResponse implements Serializable {

	private static final long serialVersionUID = -5966895553154988777L;


	private int havaleProvizyonId;
	private MusteriResponse musteri_portfoyNo;
	private Date tarih;
	private String islemTipi;
	private double islemTutari;
	private HavaleProvizyonResponse selectedHProv;

	public int getHavaleProvizyonId() {
		return havaleProvizyonId;
	}

	public HavaleProvizyonResponse getSelectedHProv() {
		return selectedHProv;
	}

	public void setSelectedHProv(HavaleProvizyonResponse selectedHProv) {
		this.selectedHProv = selectedHProv;
	}

	public void setHavaleProvizyonId(int havaleProvizyonId) {
		this.havaleProvizyonId = havaleProvizyonId;
	}

	public MusteriResponse getMusteri_portfoyNo() {
		return musteri_portfoyNo;
	}

	public void setMusteri_portfoyNo(MusteriResponse musteri_portfoyNo) {
		this.musteri_portfoyNo = musteri_portfoyNo;
	}

	public Date getTarih() {
		return tarih;
	}

	public void setTarih(Date tarih) {
		this.tarih = tarih;
	}

	public String getIslemTipi() {
		return islemTipi;
	}

	public void setIslemTipi(String islemTipi) {
		this.islemTipi = islemTipi;
	}

	public double getIslemTutari() {
		return islemTutari;
	}

	public void setIslemTutari(double islemTutari) {
		this.islemTutari = islemTutari;
	}

	
}
