package com.example.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "loginPage")
@ViewScoped
public class LoginPage implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -7905375469865386024L;

	private String username;
	private String password; 
	private String someLabel;
	

	public String getSomeLabel() {
		return someLabel;
	}

	public void setSomeLabel(String someLabel) {
		this.someLabel = someLabel;
	}

	@PostConstruct
	public void init() {
		
		setUsername("Emre_1122");
		setSomeLabel("BU HA");

		
	}

	public void login() {
		
		System.out.println("login button entered!");
		
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

	public String loginAuthentication() {
		return "OK";
	}

}