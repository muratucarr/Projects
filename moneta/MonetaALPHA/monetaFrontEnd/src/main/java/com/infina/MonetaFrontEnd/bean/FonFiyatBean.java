package com.infina.MonetaFrontEnd.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.infina.MonetaFrontEnd.DisServis.DisServisEntegrasyon;
import com.infina.MonetaFrontEnd.model.FonFiyatResponse;
import com.infina.MonetaFrontEnd.model.FonTanimiResponse;

import org.primefaces.PrimeFaces;

@ManagedBean (name = "fonFiyatBean")
@ViewScoped
public class FonFiyatBean {
	
	private int fonFiyatId;
	
	private Date tarih;
	private double fiyat;
	private FonTanimiResponse fon_FonKodu;
	
	
	@ManagedProperty(value = "#" + "{" + DisServisEntegrasyon.SERVICE_NAME + "}")
	private DisServisEntegrasyon dse;
	
	private List<FonFiyatResponse> fonFiyatList = new ArrayList<FonFiyatResponse>();
	
	HashMap<String, FonTanimiResponse> fonMap = new HashMap<>();
	
	private FonFiyatResponse selectedFonFiyat;
	
	private FonFiyatResponse selectedFonFiyatForDeletion;
	
	@PostConstruct
	public void init() {
		this.fonFiyatList = dse.getAllFonFiyat();
		
		List<FonTanimiResponse> fonList = dse.getAllFon();
		for(FonTanimiResponse fonTanimi : fonList)
		{
			fonMap.put(fonTanimi.getFonKodu() , fonTanimi);
		}
	}
	
	public void openNew() {
        this.selectedFonFiyat = new FonFiyatResponse();
    }
	
	public void saveFonFiyat() {
		
		if(this.selectedFonFiyat.getTarih() == null || this.selectedFonFiyat.getFon_FonKodu().getFonKodu().isEmpty() || this.selectedFonFiyat.getFiyat() <= 0.0)
		{
			if(this.selectedFonFiyat.getTarih() == null)
			{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "HATA", "Tarih Boş Bırakılamaz"));
			}
			
			if(this.selectedFonFiyat.getFon_FonKodu().getFonKodu().isEmpty())
			{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "HATA", "Fon Kodu Boş Bırakılamaz"));
			}
			
			if(this.selectedFonFiyat.getFiyat() <= 0.0)
			{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "HATA", "Lütfen Geçerli Bir Fiyat Giriniz"));
			}
			
			 PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
		     PrimeFaces.current().ajax().update("form:messages");
		}
		else
		{
			if(fonFiyatVarMi(this.selectedFonFiyat.getTarih() , this.selectedFonFiyat.getFon_FonKodu().getFonKodu()) == true)
			{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "HATA","Böyle Bir Kayıt Mevcut"));

		        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
		        PrimeFaces.current().ajax().update("form:messages");
			}
			
			else if(fonMap.containsKey(this.selectedFonFiyat.getFon_FonKodu().getFonKodu()) != true)
			{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "HATA","Böyle Bir Fon Kodu Yok"));

		        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
		        PrimeFaces.current().ajax().update("form:messages");
			}
			else
			{
				FonFiyatResponse fonFiyat = new FonFiyatResponse();
				fonFiyat.setTarih(this.selectedFonFiyat.getTarih());
				fonFiyat.setFiyat(this.selectedFonFiyat.getFiyat());
				fonFiyat.setFon_FonKodu(fonMap.get(this.selectedFonFiyat.getFon_FonKodu().getFonKodu()));
				
				this.dse.addFonFiyat(fonFiyat);

		        this.fonFiyatList.add(fonFiyat);
		        
		        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "BAŞARILI","Yeni Fon Fiyat Eklendi"));

		        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
		        PrimeFaces.current().ajax().update("form:messages", "form:table");
			}
		}
		
		
		
    }
	
	public boolean fonFiyatVarMi(Date tarih , String fonKodu)
	{
		for(FonFiyatResponse fonFiyat : this.fonFiyatList)
		{
			if(fonFiyat.getTarih().getDay() == tarih.getDay() && fonFiyat.getTarih().getMonth() == tarih.getMonth() &&
					fonFiyat.getTarih().getYear() == tarih.getYear() && fonFiyat.getFon_FonKodu().getFonKodu().equals(fonKodu))
			{
				return true;
			}
		}
		
		return false;
	}
	
	
	public void deleteFonFiyat() {
		
		if(this.selectedFonFiyatForDeletion == null)
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "HATA","Herhangi Bir Fon Fiyat Seçmediniz"));
	        PrimeFaces.current().ajax().update("form:messages");
		}
		else
		{
			this.dse.deleteFonFiyat(this.selectedFonFiyatForDeletion.getFonFiyatId());
			
	        this.fonFiyatList.remove(this.selectedFonFiyatForDeletion);
	        this.selectedFonFiyatForDeletion = null;
	        
	        
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "BAŞARILI","Fon Fiyat Başarıyla Silindi"));
	        PrimeFaces.current().ajax().update("form:messages", "form:table");
		}
		
		
    }
	
	

	public FonFiyatResponse getSelectedFonFiyat() {
		return selectedFonFiyat;
	}

	public void setSelectedFonFiyat(FonFiyatResponse selectedFonFiyat) {
		this.selectedFonFiyat = selectedFonFiyat;
	}
	

	public FonFiyatResponse getSelectedFonFiyatForDeletion() {
		return selectedFonFiyatForDeletion;
	}

	public void setSelectedFonFiyatForDeletion(FonFiyatResponse selectedFonFiyatForDeletion) {
		this.selectedFonFiyatForDeletion = selectedFonFiyatForDeletion;
	}

	public int getFonFiyatId() {
		return fonFiyatId;
	}

	public void setFonFiyatId(int fonFiyatId) {
		this.fonFiyatId = fonFiyatId;
	}

	public Date getTarih() {
		return tarih;
	}

	public void setTarih(Date tarih) {
		this.tarih = tarih;
	}

	public double getFiyat() {
		return fiyat;
	}

	public void setFiyat(double fiyat) {
		this.fiyat = fiyat;
	}
	

	
	public FonTanimiResponse getFon_FonKodu() {
		return fon_FonKodu;
	}



	public void setFon_FonKodu(FonTanimiResponse fon_FonKodu) {
		this.fon_FonKodu = fon_FonKodu;
	}



	public List<FonFiyatResponse> getFonFiyatList() {
		return fonFiyatList;
	}

	public void setFonFiyatList(List<FonFiyatResponse> fonFiyatList) {
		this.fonFiyatList = fonFiyatList;
	}

	public void setDse(DisServisEntegrasyon dse) {
		this.dse = dse;
	}

}