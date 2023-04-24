package com.example.bean;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;



@ManagedBean(name="loginPage")
@javax.faces.bean.ViewScoped
public class loginPage  implements Serializable{

	
	/**
	 *
	 */
	private static final long serialVersionUID = -7905375469865386024L;
	private String firstName;
	private String lastName;
	
	private String username = "ERSOY_EMRE";
	private String password = "12312123";


	@PostConstruct
	public void init() {
		
	}
	public void login(){
		System.out.println("login buton entered!");
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	
	public String loginAuthentication()
	{
		return "OK";
	}
	
}