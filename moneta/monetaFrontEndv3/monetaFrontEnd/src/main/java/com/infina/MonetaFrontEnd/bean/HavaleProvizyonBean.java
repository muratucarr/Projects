package com.infina.MonetaFrontEnd.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.infina.MonetaFrontEnd.DisServis.DisServisEntegrasyon;
import com.infina.MonetaFrontEnd.model.HavaleProvizyonResponse;
import com.infina.MonetaFrontEnd.model.MusteriResponse;

@ManagedBean(name = "havaleProvizyonBean")
@ViewScoped
public class HavaleProvizyonBean {

	private int havaleProvizyonId;
	private MusteriResponse musteri_portfoyNo;
	private Date tarih;
	private String islemTipi;
	private double islemTutari;
	private List<HavaleProvizyonResponse> HProvList = new ArrayList<>();
	
	public HavaleProvizyonResponse getSelectedHProv() {
		return selectedHProv;
	}

	public void setSelectedHProv(HavaleProvizyonResponse selectedHProv) {
		this.selectedHProv = selectedHProv;
	}

	private HavaleProvizyonResponse selectedHProv;


	@ManagedProperty(value = "#" + "{" + DisServisEntegrasyon.SERVICE_NAME + "}")
	private DisServisEntegrasyon dse;

	public void setDse(DisServisEntegrasyon dse) {
		this.dse = dse;
	}

	@PostConstruct
	public void init() {
		this.HProvList = this.dse.getAllHavaleProvizyon();
		
		
	}

	public int getHavaleProvizyonId() {
		return havaleProvizyonId;
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

	public List<HavaleProvizyonResponse> getHProvList() {
		return HProvList;
	}

	public void setHProvList(List<HavaleProvizyonResponse> hProvList) {
		HProvList = hProvList;
	}
	
	public void deleteHavaleProvizyon() {
		this.dse.deleteHavaleProvizyon(this.selectedHProv.getHavaleProvizyonId());
		this.selectedHProv = null;
	}
	
	public void saveHavaleProvizyon() {
		
	}

	/*
	 * public void savePersonel(int Portfoyno) { int status =
	 * this.dse.savePersonel(this.PortfoyNo); this.HProvList =
	 * this.dse.getAllPersonel(); this.temizle(); }
	 * 
	 * private void temizle() { this.PortfoyNo = null; }
	 */

}
