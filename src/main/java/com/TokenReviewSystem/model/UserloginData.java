package com.TokenReviewSystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class UserloginData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idUser;
	private String emailId;
	private String password;
	private String usertype;
	@OneToOne
	private UserData userdata;
	
	
	public UserloginData() {
		super();
	}
	public UserloginData(int idUser, String emailId, String password, String usertype, UserData userdata) {
		super();
		this.idUser = idUser;
		this.emailId = emailId;
		this.password = password;
		this.usertype = usertype;
		this.userdata = userdata;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public UserData getUserdata() {
		return userdata;
	}
	public void setUserdata(UserData userdata) {
		this.userdata = userdata;
	}


}
