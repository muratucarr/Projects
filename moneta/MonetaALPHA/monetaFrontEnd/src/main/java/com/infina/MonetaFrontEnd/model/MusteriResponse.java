package com.infina.MonetaFrontEnd.model;

import java.io.Serializable;

public class MusteriResponse implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = -3412178008732163273L;

	private int portfoyNo;

	private String ad;

	private String soyad;

	private String tcNo;

	private String yerlesimBelgesi;
	
	private double bakiye;

	public double getBakiye() {
		return bakiye;
	}

	public void setBakiye(double bakiye) {
		this.bakiye = bakiye;
	}

	public int getPortfoyNo() {
		return portfoyNo;
	}

	public void setPortfoyNo(int portfoyNo) {
		this.portfoyNo = portfoyNo;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public String getTcNo() {
		return tcNo;
	}

	public void setTcNo(String tcNo) {
		this.tcNo = tcNo;
	}

	public String getYerlesimBelgesi() {
		return yerlesimBelgesi;
	}

	public void setYerlesimBelgesi(String yerlesimBelgesi) {
		this.yerlesimBelgesi = yerlesimBelgesi;
	}
}
