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
import com.infina.MonetaFrontEnd.model.FonAlimSatimResponse;
import com.infina.MonetaFrontEnd.model.FonFiyatResponse;
import com.infina.MonetaFrontEnd.model.FonTanimiResponse;
import com.infina.MonetaFrontEnd.model.MusteriResponse;

import org.primefaces.PrimeFaces;

@ManagedBean (name = "fonAlimSatimBean")
@ViewScoped
public class FonAlimSatimBean {
	
	@ManagedProperty(value = "#" + "{" + DisServisEntegrasyon.SERVICE_NAME + "}")
	private DisServisEntegrasyon dse;
	
	private int alimSatimId;
	
	private MusteriResponse musteri_portfoyNo;
	private FonTanimiResponse fon_fonKodu;
	
	private Date islemTarihi;
	private String islemTipi;
	
	private String silindiMi;
	
	private double miktar;
	private double stok;
	
	private boolean disable;
	private boolean disableInput;
	
	
	private double fiyat;
	private double tutar;
	
	private List<FonAlimSatimResponse> alimSatimList = new ArrayList<FonAlimSatimResponse>();
	
	private List<FonAlimSatimResponse> gecmisIslemlerList = new ArrayList<FonAlimSatimResponse>();
	
	HashMap<String, FonTanimiResponse> fonMap = new HashMap<>();
	
	private FonAlimSatimResponse selectedFonAlimSatim;
	
	private FonAlimSatimResponse selectedFonAlimSatimForDeletion;
	
	private int selectedPortfoyNo;
	
	private double selectedBakiye;
	
	
	@PostConstruct
	public void init() 
	{
		
		this.setDisable(true);
		this.setDisableInput(false);
		
		List<FonTanimiResponse> fonList = dse.getAllFon();
		for(FonTanimiResponse fonTanimi : fonList)
		{
			fonMap.put(fonTanimi.getFonKodu() , fonTanimi);
		}
		
	}
	
	public void openNew() {
        this.selectedFonAlimSatim = new FonAlimSatimResponse();
        
        this.setDisable(true);
		this.setDisableInput(false);
		
		PrimeFaces.current().ajax().update("dialogs:kaydet1" , "dialogs:kaydet2");
    }
	
	
	public void iptalAlimSatimAl()
	{
		this.setDisable(true);
		this.setDisableInput(false);
		
		PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
		
	}
	
	public void iptalAlimSatimSat()
	{
		this.setDisable(true);
		this.setDisableInput(false);
		
		PrimeFaces.current().executeScript("PF('sellProductDialog').hide()");
	}
	
	public void deleteFonAlimSatim()
	{
		if(this.selectedPortfoyNo == 0)
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "HATA","Portföy No Girmediniz"));

	        PrimeFaces.current().executeScript("PF('deleteProductDialog').hide()");
	        PrimeFaces.current().ajax().update("form1:messages");
	        
	        return;
		}
		
		
		if(this.selectedFonAlimSatimForDeletion == null)
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "HATA","Herhangi Bir İşlem Seçmediniz"));

	        PrimeFaces.current().executeScript("PF('deleteProductDialog').hide()");
	        PrimeFaces.current().ajax().update("form2:messages2");
		}
		
		else
		{
			FonAlimSatimResponse fonAlimSatim = new FonAlimSatimResponse();
			
			fonAlimSatim.setAlimSatimId(this.selectedFonAlimSatimForDeletion.getAlimSatimId());
			
			List<MusteriResponse> butunMusteriler = this.dse.getAllMusteri();
			MusteriResponse musteri = findMusteri(this.selectedPortfoyNo , butunMusteriler);
			fonAlimSatim.setMusteri_portfoyNo(musteri);
			
			fonAlimSatim.setIslemTipi(this.selectedFonAlimSatimForDeletion.getIslemTipi());
			fonAlimSatim.setIslemTarihi(this.selectedFonAlimSatimForDeletion.getIslemTarihi());
			
			fonAlimSatim.setSilindiMi("Evet");
			
			fonAlimSatim.setFon_fonKodu(fonMap.get(this.selectedFonAlimSatimForDeletion.getFon_fonKodu().getFonKodu()));
			
			fonAlimSatim.setMiktar(this.selectedFonAlimSatimForDeletion.getMiktar());
			fonAlimSatim.setStok(this.selectedFonAlimSatimForDeletion.getStok());
			fonAlimSatim.setFiyat(this.selectedFonAlimSatimForDeletion.getFiyat());
			fonAlimSatim.setTutar(this.selectedFonAlimSatimForDeletion.getTutar());
			
			this.dse.updateFonAlimSatim(fonAlimSatim.getAlimSatimId() , fonAlimSatim);
			
			deleteGecmisIslem(this.selectedFonAlimSatimForDeletion.getAlimSatimId());
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "BAŞARILI","Geçmiş İşlem Silindi"));

	        PrimeFaces.current().executeScript("PF('deleteProductDialog').hide()");
	        PrimeFaces.current().ajax().update("form2:messages2" , "form2:table2");
			
		}
		
		
	}
	
	public void deleteGecmisIslem(int alimSatimIdToDelete)
	{
		for(int i = 0 ; i < this.gecmisIslemlerList.size() ; i++)
		{
			FonAlimSatimResponse fonAlimSatim = this.gecmisIslemlerList.get(i);
			
			if(fonAlimSatim.getAlimSatimId() == alimSatimIdToDelete)
			{
				this.gecmisIslemlerList.remove(i);
				return;
			}
		}
			
	}
	
	public void sellFonAlimSatim()
	{
		this.setDisable(true);
		this.setDisableInput(false);
		
		if(this.selectedPortfoyNo == 0)
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "HATA","Portföy No Girmediniz"));

	        PrimeFaces.current().executeScript("PF('sellProductDialog').hide()");
	        PrimeFaces.current().ajax().update("form1:messages");
	        
	        return;
		}
		
		if(this.selectedFonAlimSatim.getMiktar() <= 0.0)
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "HATA", "Geçerli Bir Miktar Giriniz"));
	        PrimeFaces.current().ajax().update("form1:messages");
	        
	        return;
		}
		
		
		double fonStok = findStok();
		
		if(fonStok >= this.selectedFonAlimSatim.getMiktar())
		{
			FonAlimSatimResponse fonAlimSatim = new FonAlimSatimResponse();
			
			List<MusteriResponse> butunMusteriler = this.dse.getAllMusteri();
			MusteriResponse musteri = findMusteri(this.selectedPortfoyNo , butunMusteriler);
			musteri.setBakiye(this.selectedBakiye + this.selectedFonAlimSatim.getMiktar() * this.selectedFonAlimSatim.getFiyat());
			
			this.dse.updateMusteri(selectedPortfoyNo, musteri);
			this.selectedBakiye += this.selectedFonAlimSatim.getMiktar() * this.selectedFonAlimSatim.getFiyat();
			
			fonAlimSatim.setMusteri_portfoyNo(musteri);
			
			fonAlimSatim.setFon_fonKodu(fonMap.get(this.selectedFonAlimSatim.getFon_fonKodu().getFonKodu()));
			
			fonAlimSatim.setIslemTarihi(new Date());
			fonAlimSatim.setIslemTipi("Satım");
			
			fonAlimSatim.setSilindiMi("Hayır");
			
			fonAlimSatim.setMiktar(this.selectedFonAlimSatim.getMiktar());
			fonAlimSatim.setStok(this.selectedFonAlimSatim.getMiktar());
			
			fonAlimSatim.setFiyat(this.selectedFonAlimSatim.getFiyat());
			fonAlimSatim.setTutar(this.selectedFonAlimSatim.getMiktar() * this.selectedFonAlimSatim.getFiyat());
			
			this.dse.addFonAlimSatim(fonAlimSatim);
			
			List<FonAlimSatimResponse> butunIslemler = this.dse.getAllAlimSatim();
			this.alimSatimList = findAlimSatim(this.selectedPortfoyNo , butunIslemler);
			this.gecmisIslemlerList = this.findGecmisIslemler(selectedPortfoyNo, butunIslemler);

			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "BAŞARILI","Yeni Fon Satım Eklendi"));

	        PrimeFaces.current().executeScript("PF('sellProductDialog').hide()");
	        PrimeFaces.current().ajax().update("form1:messages" ,"form1:bakiye" , "form1:table1" , "form2:table2");
		}
		
		else
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "HATA","Yetersiz Stok"));

	        PrimeFaces.current().executeScript("PF('sellProductDialog').hide()");
	        PrimeFaces.current().ajax().update("form1:messages");
		}
		
		
	}
	
	public double findStok()
	{
		for(FonAlimSatimResponse fonAlimSatim : this.alimSatimList)
		{
			if(fonAlimSatim.getFon_fonKodu().getFonKodu().equals(this.selectedFonAlimSatim.getFon_fonKodu().getFonKodu()))
			{
				return fonAlimSatim.getStok();
			}
		}
		
		return -1;
	}
	
	
	public void saveFonAlimSatim()
	{
		this.setDisable(true);
		this.setDisableInput(false);
		
		
		if(this.selectedPortfoyNo == 0)
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "HATA","Portföy No Girmediniz"));

	        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
	        PrimeFaces.current().ajax().update("form1:messages");
	        
	        return;
		}
		
		
		if(this.selectedFonAlimSatim.getMiktar() <= 0.0)
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "HATA", "Geçerli Bir Miktar Giriniz"));
	        PrimeFaces.current().ajax().update("form1:messages");
	        
	        return;
		}
		
		
		
		if(this.selectedBakiye >= this.selectedFonAlimSatim.getMiktar() * this.selectedFonAlimSatim.getFiyat())
		{
			FonAlimSatimResponse fonAlimSatim = new FonAlimSatimResponse();
			
			List<MusteriResponse> butunMusteriler = this.dse.getAllMusteri();
			MusteriResponse musteri = findMusteri(this.selectedPortfoyNo , butunMusteriler);
			musteri.setBakiye(this.selectedBakiye - this.selectedFonAlimSatim.getMiktar() * this.selectedFonAlimSatim.getFiyat());
			
			this.dse.updateMusteri(selectedPortfoyNo, musteri);
			this.selectedBakiye -= this.selectedFonAlimSatim.getMiktar() * this.selectedFonAlimSatim.getFiyat();
			
			fonAlimSatim.setMusteri_portfoyNo(musteri);
			
			fonAlimSatim.setFon_fonKodu(fonMap.get(this.selectedFonAlimSatim.getFon_fonKodu().getFonKodu()));
			
			fonAlimSatim.setIslemTarihi(new Date());
			fonAlimSatim.setIslemTipi("Alım");
			
			fonAlimSatim.setSilindiMi("Hayır");
			
			fonAlimSatim.setMiktar(this.selectedFonAlimSatim.getMiktar());
			fonAlimSatim.setStok(this.selectedFonAlimSatim.getMiktar());
			
			fonAlimSatim.setFiyat(this.selectedFonAlimSatim.getFiyat());
			fonAlimSatim.setTutar(this.selectedFonAlimSatim.getMiktar() * this.selectedFonAlimSatim.getFiyat());
			
			
			this.dse.addFonAlimSatim(fonAlimSatim);
			
			List<FonAlimSatimResponse> butunIslemler = this.dse.getAllAlimSatim();
			this.alimSatimList = findAlimSatim(this.selectedPortfoyNo , butunIslemler);
			this.gecmisIslemlerList = this.findGecmisIslemler(this.selectedPortfoyNo, butunIslemler);
			
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "BAŞARILI","Yeni Fon Alım Eklendi"));

	        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
	        PrimeFaces.current().ajax().update("form1:messages" ,"form1:bakiye" , "form1:table1" , "form2:table2");
			
		}
		else
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "HATA","Yetersiz Bakiye"));

	        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
	        PrimeFaces.current().ajax().update("form1:messages");
		}
	}
	
	
	public void calculateFiyatForAlim()
	{
		if(this.selectedFonAlimSatim.getFon_fonKodu().getFonKodu().isEmpty())
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "HATA", "Fon Kodu Boş Bırakılamaz"));
	        PrimeFaces.current().ajax().update("form1:messages");
	        
	        return;
		}
		
		if(this.fonMap.containsKey(this.selectedFonAlimSatim.getFon_fonKodu().getFonKodu()) != true)
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "HATA", "Geçerli Bir Fon Kodu Giriniz"));
	        PrimeFaces.current().ajax().update("form1:messages");
	        
	        return;
		}
		
		
		
		
		Date today = new Date();
		
		List<FonFiyatResponse> fonFiyatList = this.dse.getAllFonFiyat();
		for(FonFiyatResponse x : fonFiyatList)
		{
			if(x.getTarih().getDate() == today.getDate() && x.getTarih().getMonth() == today.getMonth() && x.getTarih().getYear() == today.getYear() &&
					x.getFon_FonKodu().getFonKodu().equals(this.selectedFonAlimSatim.getFon_fonKodu().getFonKodu()))
			{
				this.selectedFonAlimSatim.setFiyat(x.getFiyat());
				this.setDisable(false);
				this.setDisableInput(true);
				PrimeFaces.current().ajax().update("dialogs:manage-product-content" , "dialogs:kaydet1");
				
				return;
			}
		}
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "HATA", "Bugün İçin Bu Fona Ait Bir Fiyat Yoktur"));
        PrimeFaces.current().ajax().update("form1:messages");
		
	}
	
	public void calculateFiyatForSatim()
	{
		if(this.selectedFonAlimSatim.getFon_fonKodu().getFonKodu().isEmpty())
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "HATA", "Fon Kodu Boş Bırakılamaz"));
	        PrimeFaces.current().ajax().update("form1:messages");
	        
	        return;
		}
		
		if(this.fonMap.containsKey(this.selectedFonAlimSatim.getFon_fonKodu().getFonKodu()) != true)
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "HATA", "Geçerli Bir Fon Kodu Giriniz"));
	        PrimeFaces.current().ajax().update("form1:messages");
	        
	        return;
		}
		
		
		
		Date today = new Date();
		
		List<FonFiyatResponse> fonFiyatList = this.dse.getAllFonFiyat();
		for(FonFiyatResponse x : fonFiyatList)
		{
			if(x.getTarih().getDate() == today.getDate() && x.getTarih().getMonth() == today.getMonth() && x.getTarih().getYear() == today.getYear() &&
					x.getFon_FonKodu().getFonKodu().equals(this.selectedFonAlimSatim.getFon_fonKodu().getFonKodu()))
			{
				this.selectedFonAlimSatim.setFiyat(x.getFiyat());
				this.setDisable(false);
				this.setDisableInput(true);
				PrimeFaces.current().ajax().update("dialogs:sell-product-content" , "dialogs:kaydet2");
				
				return;
			}
		}
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "HATA", "Bugün İçin Bu Fona Ait Bir Fiyat Yoktur"));
		PrimeFaces.current().ajax().update("form1:messages");
	}
	
	
	public void getTablolar()
	{
		List<FonAlimSatimResponse> butunIslemler = this.dse.getAllAlimSatim();
		List<MusteriResponse> butunMusteriler = this.dse.getAllMusteri();
		
		
		if(this.selectedPortfoyNo == 0)
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "HATA","Portföy No Girmediniz"));
	        PrimeFaces.current().ajax().update("form1:messages");
	        
	        return;
		}
		
		
		if(findMusteri(this.selectedPortfoyNo , butunMusteriler) == null)
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "HATA","Böyle Bir Müşteri Bulunamadı"));
	        PrimeFaces.current().ajax().update("form1:messages");
	        
	        return;
		}
		
		this.selectedBakiye = findMusteriBakiye(this.selectedPortfoyNo , butunMusteriler);
		
		this.alimSatimList = findAlimSatim(this.selectedPortfoyNo , butunIslemler);
		this.gecmisIslemlerList = findGecmisIslemler(this.selectedPortfoyNo , butunIslemler);
		
		
		PrimeFaces.current().ajax().update("form1:bakiye" , "form1:table1" , "form2:table2");
		
	}
	
	public List<FonAlimSatimResponse> findAlimSatim(int portfoyNo , List<FonAlimSatimResponse> butunIslemler)
	{
		List<FonAlimSatimResponse> resultList = new ArrayList<FonAlimSatimResponse>();
		
		for(FonAlimSatimResponse alimSatim : butunIslemler)
		{
			
			if(alimSatim.getMusteri_portfoyNo().getPortfoyNo() == portfoyNo)
			{
				boolean var_mi = false;
				for(FonAlimSatimResponse x : resultList)
				{
					if(x.getFon_fonKodu().getFonKodu().equals(alimSatim.getFon_fonKodu().getFonKodu()))
					{
						if(alimSatim.getIslemTipi().equals("Alım"))
						{
							x.setStok(x.getStok() + alimSatim.getStok());
						}
						else
						{
							x.setStok(x.getStok() - alimSatim.getStok());
						}
						
						var_mi = true;
					}
				}
				
				if(var_mi == false)
				{
					resultList.add(alimSatim);
				}
			}
			
		}
		
		return resultList;
	}
	
	
	public List<FonAlimSatimResponse> findGecmisIslemler(int portfoyNo , List<FonAlimSatimResponse> butunIslemler)
	{
		List<FonAlimSatimResponse> resultList = new ArrayList<FonAlimSatimResponse>();
		
		for(FonAlimSatimResponse alimSatim : butunIslemler)
		{
			
			if(alimSatim.getMusteri_portfoyNo().getPortfoyNo() == portfoyNo && alimSatim.getSilindiMi().equals("Hayır"))
			{
				resultList.add(alimSatim);
			}
			
		}
		
		return resultList;
		
	}
	
	public double findMusteriBakiye(int portfoyNo , List<MusteriResponse> butunMusteriler)
	{
		for(MusteriResponse musteri : butunMusteriler)
		{
			if(musteri.getPortfoyNo() == portfoyNo)
			{
				return musteri.getBakiye();
			}
		}
		
		return -1;
		
	}
	
	public MusteriResponse findMusteri(int portfoyNo , List<MusteriResponse> butunMusteriler)
	{
		for(MusteriResponse musteri : butunMusteriler)
		{
			if(musteri.getPortfoyNo() == portfoyNo)
			{
				return musteri;
			}
		}
		
		return null;
		
	}


	public MusteriResponse getMusteri_portfoyNo() {
		return musteri_portfoyNo;
	}


	public void setMusteri_portfoyNo(MusteriResponse musteri_portfoyNo) {
		this.musteri_portfoyNo = musteri_portfoyNo;
	}


	public FonTanimiResponse getFon_fonKodu() {
		return fon_fonKodu;
	}


	public void setFon_fonKodu(FonTanimiResponse fon_fonKodu) {
		this.fon_fonKodu = fon_fonKodu;
	}


	public Date getIslemTarihi() {
		return islemTarihi;
	}


	public void setIslemTarihi(Date islemTarihi) {
		this.islemTarihi = islemTarihi;
	}


	public String getIslemTipi() {
		return islemTipi;
	}


	public void setIslemTipi(String islemTipi) {
		this.islemTipi = islemTipi;
	}


	

	public double getMiktar() {
		return miktar;
	}

	public void setMiktar(double miktar) {
		this.miktar = miktar;
	}

	public double getStok() {
		return stok;
	}

	public void setStok(double stok) {
		this.stok = stok;
	}

	public double getFiyat() {
		return fiyat;
	}

	public void setFiyat(double fiyat) {
		this.fiyat = fiyat;
	}

	public double getTutar() {
		return tutar;
	}

	public void setTutar(double tutar) {
		this.tutar = tutar;
	}

	public List<FonAlimSatimResponse> getAlimSatimList() {
		return alimSatimList;
	}


	public void setAlimSatimList(List<FonAlimSatimResponse> alimSatimList) {
		this.alimSatimList = alimSatimList;
	}


	public List<FonAlimSatimResponse> getGecmisIslemlerList() {
		return gecmisIslemlerList;
	}


	public void setGecmisIslemlerList(List<FonAlimSatimResponse> gecmisIslemlerList) {
		this.gecmisIslemlerList = gecmisIslemlerList;
	}


	public FonAlimSatimResponse getSelectedFonAlimSatim() {
		return selectedFonAlimSatim;
	}


	public void setSelectedFonAlimSatim(FonAlimSatimResponse selectedFonAlimSatim) {
		this.selectedFonAlimSatim = selectedFonAlimSatim;
	}


	public FonAlimSatimResponse getSelectedFonAlimSatimForDeletion() {
		return selectedFonAlimSatimForDeletion;
	}


	public void setSelectedFonAlimSatimForDeletion(FonAlimSatimResponse selectedFonAlimSatimForDeletion) {
		this.selectedFonAlimSatimForDeletion = selectedFonAlimSatimForDeletion;
	}


	public void setDse(DisServisEntegrasyon dse) {
		this.dse = dse;
	}


	public int getSelectedPortfoyNo() {
		return selectedPortfoyNo;
	}


	public void setSelectedPortfoyNo(int selectedPortfoyNo) {
		this.selectedPortfoyNo = selectedPortfoyNo;
	}

	public double getSelectedBakiye() {
		return selectedBakiye;
	}

	public void setSelectedBakiye(double selectedBakiye) {
		this.selectedBakiye = selectedBakiye;
	}

	public int getAlimSatimId() {
		return alimSatimId;
	}

	public void setAlimSatimId(int alimSatimId) {
		this.alimSatimId = alimSatimId;
	}

	public String getSilindiMi() {
		return silindiMi;
	}

	public void setSilindiMi(String silindiMi) {
		this.silindiMi = silindiMi;
	}

	public boolean isDisable() {
		return disable;
	}

	public void setDisable(boolean disable) {
		this.disable = disable;
	}

	public boolean isDisableInput() {
		return disableInput;
	}

	public void setDisableInput(boolean disableInput) {
		this.disableInput = disableInput;
	}

}