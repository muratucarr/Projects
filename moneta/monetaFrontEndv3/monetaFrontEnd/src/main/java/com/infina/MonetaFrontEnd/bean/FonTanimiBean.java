package com.infina.MonetaFrontEnd.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.infina.MonetaFrontEnd.DisServis.DisServisEntegrasyon;
import com.infina.MonetaFrontEnd.model.FonTanimiResponse;

@ManagedBean (name = "fonTanimiBean")
@ViewScoped
public class FonTanimiBean {
	
	private String fonKodu;
	private String fonAdi;
	private String isinKodu;
	
	@ManagedProperty(value = "#" + "{" + DisServisEntegrasyon.SERVICE_NAME + "}")
	private DisServisEntegrasyon dse;
	
	private List<FonTanimiResponse> fonList = new ArrayList<FonTanimiResponse>();
	
	@PostConstruct
	public void init() {
		this.fonList = dse.getAllFon();
	}
	
	public List<FonTanimiResponse> getFonList() {
		return fonList;
	}

	public void setFonList(List<FonTanimiResponse> fonList) {
		this.fonList = fonList;
	}


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

	public void setDse(DisServisEntegrasyon dse) {
		this.dse = dse;
	}
	
	

}