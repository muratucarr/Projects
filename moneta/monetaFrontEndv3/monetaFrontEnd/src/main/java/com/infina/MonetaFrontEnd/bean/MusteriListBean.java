package com.infina.MonetaFrontEnd.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.infina.MonetaFrontEnd.DisServis.DisServisEntegrasyon;
import com.infina.MonetaFrontEnd.model.MusteriResponse;


@ManagedBean(name = "musteriListBean")
@ViewScoped
public class MusteriListBean {
	
	
	private int portfoyNo;
	private String ad;
	private String soyad;
	private String tcNo;
	
	private String yerlesimBelgesi;
	private List<MusteriResponse> musteriList = new ArrayList<>();
	

	
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

	public List<MusteriResponse> getmusteriList() {
		return musteriList;
	}

	public void setmusteriList(List<MusteriResponse> musteriList) {
		this.musteriList = musteriList;
	}


	@ManagedProperty(value = "#" + "{" + DisServisEntegrasyon.SERVICE_NAME + "}")
	private DisServisEntegrasyon dse;

	public void setDse(DisServisEntegrasyon dse) {
		this.dse = dse;
	}

	@PostConstruct
	public void init() {
		this.musteriList = this.dse.getAllMusteri();
	}
	
	public void saveMusteri() {
		MusteriResponse newMusteri = new MusteriResponse();
		newMusteri.setPortfoyNo(this.portfoyNo);
		newMusteri.setAd(this.ad);
		newMusteri.setSoyad(soyad);
		newMusteri.setTcNo(this.tcNo);
		newMusteri.setYerlesimBelgesi(this.yerlesimBelgesi);
		
		System.out.println(newMusteri.getAd() +" " + newMusteri.getSoyad() + " " + newMusteri.getPortfoyNo());
		
		this.dse.addMusteriList(newMusteri);
	}

	
}
