package com.infina.MonetaFrontEnd.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.infina.MonetaFrontEnd.DisServis.DisServisEntegrasyon;
import com.infina.MonetaFrontEnd.model.HavaleProvizyonResponse;
import com.infina.MonetaFrontEnd.model.MusteriResponse;
import com.infina.MonetaFrontEnd.utils.MonetaUtilsImpl;

import org.primefaces.PrimeFaces;

@ManagedBean(name = "havaleProvizyonBean")
@ViewScoped
public class HavaleProvizyonBean {

	private int havaleProvizyonId;
	private MusteriResponse musteri_portfoyNo = new MusteriResponse();
	private Date tarih;
	private String islemTipi;
	private double islemTutari;
	private List<HavaleProvizyonResponse> hProvList = new ArrayList<>();
	private boolean disable;
	private List<HavaleProvizyonResponse> SelectedHavaleProvizyon;
	private MonetaUtilsImpl EverythingYouAreLookingFor = new MonetaUtilsImpl ();
	private HavaleProvizyonResponse selectedHProv;
	private int selectedPortfoyNo;
	
	public int getSelectedPortfoyNo() {
		return selectedPortfoyNo;
	}

	public void setSelectedPortfoyNo(int selectedPortfoyNo) {
		this.selectedPortfoyNo = selectedPortfoyNo;
	}

	public boolean isDisable() {
		return disable;
	}

	public void setDisable(boolean disable) {
		this.disable = disable;
	}

	public void setSelectedHProv(HavaleProvizyonResponse selectedHProv) {
		this.selectedHProv = selectedHProv;
	}



	@ManagedProperty(value = "#" + "{" + DisServisEntegrasyon.SERVICE_NAME + "}")
	private DisServisEntegrasyon dse;

	public void setDse(DisServisEntegrasyon dse) {
		this.dse = dse;
	}

	@PostConstruct
	public void init() {
		this.hProvList = this.dse.getAllHavaleProvizyon();
		this.setDisable(true);
		this.setTarih(EverythingYouAreLookingFor.getDate());
		
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

	public HavaleProvizyonResponse getSelectedHProv() {
		return selectedHProv;
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

	public List<HavaleProvizyonResponse> gethProvList() {
		return hProvList;
	}

	public void sethProvList(List<HavaleProvizyonResponse> hProvList) {
		this.hProvList = hProvList;
	}
	
	public void deleteHavaleProvizyon() {
		
		if(this.selectedHProv ==  null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "HATA", "Silmek için Hiçbir Şey Seçmediniz"));
			return;
		}
		
		if(this.selectedHProv.getIslemTipi().equals("Havale")) {
			this.musteri_portfoyNo.setBakiye(this.getMusteri_portfoyNo().getBakiye() + this.selectedHProv.getIslemTutari());
			this.dse.updateMusteri(this.getMusteri_portfoyNo().getPortfoyNo(), this.musteri_portfoyNo);
			this.dse.deleteHavaleProvizyon(this.selectedHProv.getHavaleProvizyonId());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"BAŞARILI","Seçili Havale İşlemi Başarıyla Silindi"));

		}
		else if(this.selectedHProv.getIslemTipi().equals("Provizyon")){
			
			if(this.getIslemTutari() > this.getMusteri_portfoyNo().getBakiye()) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "HATA", "İşlem Tutarı Bakiyeden Yüksek Olamaz !"));
			}
			else {
			this.musteri_portfoyNo.setBakiye(this.getMusteri_portfoyNo().getBakiye() - this.selectedHProv.getIslemTutari());
			this.dse.updateMusteri(this.getMusteri_portfoyNo().getPortfoyNo(), this.musteri_portfoyNo);
			this.dse.deleteHavaleProvizyon(this.selectedHProv.getHavaleProvizyonId());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"BAŞARILI","Seçili Provizyon İşlemi Başarıyla Silindi"));
			}
		}
	
		
		this.selectedHProv = null;
		this.hProvList = new ArrayList<>();
		for(HavaleProvizyonResponse X: this.dse.getAllHavaleProvizyon()) {
			if (X.getMusteri_portfoyNo().getPortfoyNo() == this.selectedPortfoyNo)
				this.hProvList.add(X);
		}
		PrimeFaces.current().ajax().update("form1:bakiye" , "form2:table" ,"form1:option" , "form1:tutar" ,"form1:ourButton");

	}
	
	public void saveHavaleProvizyon() {
		HavaleProvizyonResponse newHavaleProvizyon = new HavaleProvizyonResponse();
		newHavaleProvizyon.setHavaleProvizyonId(havaleProvizyonId);
		newHavaleProvizyon.setIslemTipi(islemTipi);
		newHavaleProvizyon.setIslemTutari(islemTutari);
		newHavaleProvizyon.setMusteri_portfoyNo(musteri_portfoyNo);
		newHavaleProvizyon.setTarih(tarih);
		
		if(this.getIslemTipi().equals("Havale")) {
			if(this.getIslemTutari() > this.getMusteri_portfoyNo().getBakiye()) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "HATA", "İşlem Tutarı Bakiyeden Yüksek Olamaz !"));
			}
			else {
				this.musteri_portfoyNo.setBakiye(this.getMusteri_portfoyNo().getBakiye() - this.getIslemTutari());
				this.dse.addHavaleProvizyon(newHavaleProvizyon);
				this.dse.updateMusteri(selectedPortfoyNo, musteri_portfoyNo);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"BAŞARILI","Havale İşlemi Başarıyla Oluşturuldu"));
		}
			}
		else if (this.getIslemTipi().equals("Provizyon")){
			this.musteri_portfoyNo.setBakiye(this.getMusteri_portfoyNo().getBakiye() + this.getIslemTutari());
			this.dse.addHavaleProvizyon(newHavaleProvizyon);
			this.dse.updateMusteri(selectedPortfoyNo, musteri_portfoyNo);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"BAŞARILI","Provizyon İşlemi Başarıyla Oluşturuldu"));
		}
		else {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "HATA", "İşlem Tipi Boş Bırakılamaz"));
		}
				
		this.hProvList = new ArrayList<>();
		for(HavaleProvizyonResponse X: this.dse.getAllHavaleProvizyon()) {
			if (X.getMusteri_portfoyNo().getPortfoyNo() == this.selectedPortfoyNo)
				this.hProvList.add(X);
		}
		
		PrimeFaces.current().ajax().update("form1:bakiye" , "form2:table");
		
	}
	
	
	
	public void TabloFiltre() {
		
		boolean check = false;
		SelectedHavaleProvizyon = new ArrayList<>();
		
		
		for(MusteriResponse M: this.dse.getAllMusteri()) {
			if(M.getPortfoyNo() == this.getSelectedPortfoyNo()) {
				this.setMusteri_portfoyNo(M);
				check = true;
			}
		}
				
		for (HavaleProvizyonResponse X : this.dse.getAllHavaleProvizyon()) {
			if(X.getMusteri_portfoyNo().getPortfoyNo() == this.musteri_portfoyNo.getPortfoyNo()) {
				SelectedHavaleProvizyon.add(X);
			}
		}
		
		
		if(check) {
		this.sethProvList(SelectedHavaleProvizyon);
		this.setDisable(false);
		}
		
		else {
			this.sethProvList(this.dse.getAllHavaleProvizyon());
			this.setDisable(true);
			this.setIslemTutari(0);
			this.setIslemTipi("");
			if(this.getMusteri_portfoyNo() != null) {
				this.getMusteri_portfoyNo().setBakiye(0);
			}
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "HATA", "Bu Portföy Numarasına Kayıtlı Bir Müşteri Bulunamadı"));
		}
		
		PrimeFaces.current().ajax().update("form1:bakiye" , "form2:table" ,"form1:option" , "form1:tutar" ,"form1:ourButton");

	}

}
