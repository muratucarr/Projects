package com.infina.MonetaFrontEnd.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.infina.MonetaFrontEnd.DisServis.DisServisEntegrasyon;
import com.infina.MonetaFrontEnd.model.PersonelResponse;

@ManagedBean (name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 7765876811740798583L;

	
	private String username;
	private String password;
	@ManagedProperty(value = "#" + "{" + DisServisEntegrasyon.SERVICE_NAME + "}")
	private DisServisEntegrasyon dse;
	
	private boolean loggedIn;

	
	public String doLogin() {
		for (PersonelResponse user: this.dse.getAllPersonel()) {
			if (user.getKullaniciAdi().equals(username) ) {
				if(user.getSifre().equals(password)) {
				loggedIn = true;
				return "secured/AnaMenu";
				}
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "UYARI", "Şifre Eşleşmedi"));
				return null;
			}
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "HATA", "Böyle Bir Kullanıcı Adı Bulunamadı"));
		return null;
	}
	
	public String doLogout() {
		loggedIn = false;

		ExternalContext ec = FacesContext.getCurrentInstance()
		        .getExternalContext();
		try {
		    ec.redirect(ec.getRequestContextPath()
		            + "/loginPage.xhtml");
		} catch (IOException e) {

		    e.printStackTrace();
		}
		
		return "main";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public void setDse(DisServisEntegrasyon dse) {
		this.dse = dse;
	}

}