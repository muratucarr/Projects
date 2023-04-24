package com.infina.MonetaFrontEnd.model;

import java.io.Serializable;

public class FonTanimiResponse implements Serializable{

	private static final long serialVersionUID = -509575457377998414L;
	
	private String fonKodu; 
	private String fonAdi;
	private String isinKodu;
	
	
	public String getFonKodu() {
		return fonKodu;
	}
	public void setFonKodu(String fonKodu) {
		this.fonKodu = fonKodu;
	}
	public String getFonAdi() {
		return fonAdi;
	}
	public void setFonAdi(String fonAdi) {
		this.fonAdi = fonAdi;
	}
	public String getIsinKodu() {
		return isinKodu;
	}
	public void setIsinKodu(String isinKodu) {
		this.isinKodu = isinKodu;
	}
	

}