package com.infina.MonetaFrontEnd.bean;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.infina.MonetaFrontEnd.DisServis.DisServisEntegrasyon;
import com.infina.MonetaFrontEnd.model.PersonelResponse;

@ManagedBean (name = "havaleProvizyonBean")
@ViewScoped
public class HavaleProvizyonBean {

	private int PortfoyNo;
	private Date date;
	private List<PersonelResponse> HProvList = new ArrayList<>();	
	
	@ManagedProperty(value = "#" + "{" + DisServisEntegrasyon.SERVICE_NAME + "}")
	private DisServisEntegrasyon dse;
	
	public void setDse(DisServisEntegrasyon dse) {
		this.dse = dse;
	}
	



	@PostConstruct
	public void init() {
		this.HProvList = this.dse.getAllPersonel();
	}
	
/*	public void savePersonel(int Portfoyno) {
		int status = this.dse.savePersonel(this.PortfoyNo);
		this.HProvList = this.dse.getAllPersonel();
		this.temizle();	
	}
	
	private void temizle() {
		this.PortfoyNo = null;
	}
*/
	public int getPortfoyNo() {
		return PortfoyNo;
	}

	public void setPortfoyNo(int portfoyNo) {
		PortfoyNo = portfoyNo;
	}

	public List<PersonelResponse> getHProvList() {
		return HProvList;
	}

	public void setHProvList(List<PersonelResponse> HProvList) {
		this.HProvList = HProvList;
	}
	
}
