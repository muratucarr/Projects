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
import com.infina.MonetaFrontEnd.model.FonTanimiResponse;

import org.primefaces.PrimeFaces;

@ManagedBean (name = "fonTanimiBean")
@ViewScoped
public class FonTanimiBean {
	
	private String fonKodu;
	private String fonAdi;
	private String isinKodu;
	
	@ManagedProperty(value = "#" + "{" + DisServisEntegrasyon.SERVICE_NAME + "}")
	private DisServisEntegrasyon dse;
	
	private List<FonTanimiResponse> fonList = new ArrayList<FonTanimiResponse>();
	
	private FonTanimiResponse selectedFonTanimi;
	
	@PostConstruct
	public void init() {
		this.fonList = dse.getAllFon();
		
	}
	
	public void openNew() {
        this.selectedFonTanimi = new FonTanimiResponse();
    }
	
	public void saveFonTanimi() {
		
		if(this.selectedFonTanimi.getFonKodu().isEmpty() || this.selectedFonTanimi.getFonAdi().isEmpty() || this.selectedFonTanimi.getIsinKodu().isEmpty())
		{
			if(this.selectedFonTanimi.getFonKodu().isEmpty())
			{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "HATA", "Fon Kodu Boş Bırakılamaz"));
			}
			
			if(this.selectedFonTanimi.getFonAdi().isEmpty())
			{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "HATA", "Fon Adi Boş Bırakılamaz"));
			}
			
			if(this.selectedFonTanimi.getIsinKodu().isEmpty())
			{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "HATA", "ISIN Kodu Boş Bırakılamaz"));
			}
			
			 PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
		     PrimeFaces.current().ajax().update("form:messages");
			
			
		}
		else
		{
			if(fonVarMi(this.selectedFonTanimi.getFonKodu() , this.selectedFonTanimi.getFonAdi() , this.selectedFonTanimi.getIsinKodu()) == true)
			{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "HATA", "Fon Zaten Var"));

		        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
		        PrimeFaces.current().ajax().update("form:messages");
			}
			else
			{
				FonTanimiResponse fonTanimi = new FonTanimiResponse();
				fonTanimi.setFonKodu(this.selectedFonTanimi.getFonKodu());
				fonTanimi.setFonAdi(this.selectedFonTanimi.getFonAdi());
				fonTanimi.setIsinKodu(this.selectedFonTanimi.getIsinKodu());
				
				this.dse.addFonTanimi(fonTanimi);

		        this.fonList.add(fonTanimi);
		        
		        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "BAŞARILI", "Yeni Fon Eklendi"));

		        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
		        PrimeFaces.current().ajax().update("form:messages", "form:table");
		    }
		}
		
		
		
	}
	
	public boolean fonVarMi(String fonKodu , String fonAdi , String isinKodu)
	{
		for(FonTanimiResponse fonTanimi : this.fonList)
		{
			if(fonTanimi.getFonKodu().equals(fonKodu) || fonTanimi.getFonAdi().equals(fonAdi) || fonTanimi.getIsinKodu().equals(isinKodu))
			{
				return true;
			}
		}
		
		return false;
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

	public FonTanimiResponse getSelectedFonTanimi() {
		return selectedFonTanimi;
	}

	public void setSelectedFonTanimi(FonTanimiResponse selectedFonTanimi) {
		this.selectedFonTanimi = selectedFonTanimi;
	}
	
	

}