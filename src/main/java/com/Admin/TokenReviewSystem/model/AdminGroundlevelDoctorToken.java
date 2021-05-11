package com.Admin.TokenReviewSystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AdminGroundlevelDoctorToken {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int AD_id;
	private String emailid;
	private String first_name;
	private String middle_name;
	private String last_name;
	private String phonenumber;
	private String city;
	private String pincode;
	private String state;
	private String gender;
    private String doctorTypeToken;
    private String messageToDoctor;
    
	public AdminGroundlevelDoctorToken() {
		super();
	}
	
	public AdminGroundlevelDoctorToken(int aD_id, String emailid, String first_name, String middle_name,
			String last_name, String phonenumber, String city, String pincode, String state, String gender,
			String doctorTypeToken, String messageToDoctor) {
		super();
		AD_id = aD_id;
		this.emailid = emailid;
		this.first_name = first_name;
		this.middle_name = middle_name;
		this.last_name = last_name;
		this.phonenumber = phonenumber;
		this.city = city;
		this.pincode = pincode;
		this.state = state;
		this.gender = gender;
		this.doctorTypeToken = doctorTypeToken;
		this.messageToDoctor = messageToDoctor;
	}
	public int getAD_id() {
		return AD_id;
	}
	public void setAD_id(int aD_id) {
		AD_id = aD_id;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getMiddle_name() {
		return middle_name;
	}
	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDoctorTypeToken() {
		return doctorTypeToken;
	}
	public void setDoctorTypeToken(String doctorTypeToken) {
		this.doctorTypeToken = doctorTypeToken;
	}
	public String getMessageToDoctor() {
		return messageToDoctor;
	}
	public void setMessageToDoctor(String messageToDoctor) {
		this.messageToDoctor = messageToDoctor;
	}
}
