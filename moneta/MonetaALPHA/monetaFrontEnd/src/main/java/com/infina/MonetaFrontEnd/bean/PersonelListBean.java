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
import com.infina.MonetaFrontEnd.model.PersonelResponse;
import com.infina.MonetaFrontEnd.utils.MonetaUtilsImpl;

@ManagedBean(name = "personelListBean")
@ViewScoped
public class PersonelListBean {

	private String ad;
	private String soyad;
	private String kullaniciAdi;
	private String sifre;
	
	@ManagedProperty(value = "#" + "{" + DisServisEntegrasyon.SERVICE_NAME + "}")
	private DisServisEntegrasyon dse;

	public void setDse(DisServisEntegrasyon dse) {
		this.dse = dse;
	}

	private List<PersonelResponse> personelList = new ArrayList<PersonelResponse>();

	@PostConstruct
	public void init() {
		
		this.personelList = dse.getAllPersonel();
	}

	public String LoginPage() {
		for (int i = 0; i < dse.getAllPersonel().size(); i++) {
			if (this.personelList.get(i).getKullaniciAdi().equals(getKullaniciAdi())) {
				if (this.personelList.get(i).getSifre().equals(getSifre())) {
					return "main";
				}
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "UYARI", "Şifre Eşleşmedi"));
				return null;
			}
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "HATA", "Böyle Bir Kullanıcı Adı Bulunamadı"));
		return null;
	}
	
	public List<PersonelResponse> getPersonelList() {
		return personelList;
	}
	

	public void setPersonelList(List<PersonelResponse> personelList) {
		this.personelList = personelList;
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

	public String getKullaniciAdi() {
		return kullaniciAdi;
	}

	public void setKullaniciAdi(String kullaniciAdi) {
		this.kullaniciAdi = kullaniciAdi;
	}

	public String getSifre() {
		return sifre;
	}

	public void setSifre(String sifre) {
		this.sifre = sifre;
	}

}
