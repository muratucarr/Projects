package com.infina.MonetaFrontEnd.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.infina.MonetaFrontEnd.DisServis.DisServisEntegrasyon;
import com.infina.MonetaFrontEnd.model.MusteriResponse;

import org.primefaces.PrimeFaces;


@ManagedBean(name = "musteriListBean")
@ViewScoped
public class MusteriListBean {
	
	
	private int portfoyNo;
	private String ad;
	private String soyad;
	private String tcNo;
	private double bakiye;
	
	public double getBakiye() {
		return bakiye;
	}

	public void setBakiye(double bakiye) {
		this.bakiye = bakiye;
	}


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
		int HataCounter = 0;
		
		newMusteri.setPortfoyNo(this.portfoyNo);
		newMusteri.setAd(this.ad);
		newMusteri.setSoyad(soyad);
		newMusteri.setTcNo(this.tcNo);
		newMusteri.setYerlesimBelgesi(this.yerlesimBelgesi);
		newMusteri.setBakiye(this.bakiye);
		
		if(newMusteri.getPortfoyNo() == 0) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "HATA", "Portföy No 0 Olamaz"));
			HataCounter++;
		}
		
		if(newMusteri.getYerlesimBelgesi().equals("")) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "HATA", "Yerleşim Belgesi Boş Kalamaz"));
			HataCounter++;
		}
		
		
		for(MusteriResponse MusteriVar : musteriList) {
			if(MusteriVar.getTcNo().equals(newMusteri.getTcNo())) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "HATA", "Müşteri Zaten Kayıtlı Veya Kayıtlı Bir Müşteri İle Aynı TC Numarasına Sahip"));
				HataCounter++;
			}
			if(MusteriVar.getPortfoyNo() == newMusteri.getPortfoyNo()) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "HATA", "Müşteri Zaten Kayıtlı Veya Kayıtlı Bir Müşteri İle Aynı Portföy Numarasına Sahip"));
				HataCounter++;
			}
		}
		
		if(HataCounter == 0) {
			 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"BAŞARILI","Müşteri Başarıyla Oluşturuldu"));
			this.dse.addMusteriList(newMusteri);
			this.musteriList = this.dse.getAllMusteri();
	        PrimeFaces.current().ajax().update("form1:portföyNo" , "form1:tcNo" , "form1:ad" , "form1:soyad" , "form1:bakiye" ,"form1:option", "form2:table");

		}
	}

	
}
