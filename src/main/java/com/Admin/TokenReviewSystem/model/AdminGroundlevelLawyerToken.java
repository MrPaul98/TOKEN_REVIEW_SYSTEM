package com.Admin.TokenReviewSystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AdminGroundlevelLawyerToken {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int AL_id;
	private String emailid;
	private String first_name;
	private String middle_name;
	private String last_name;
	private String phonenumber;
	private String city;
	private String pincode;
	private String state;
	private String type_of_lawyer;
	private String message_to_lawyer;
	private String appoinment_date;
	
	public AdminGroundlevelLawyerToken() {
		super();
	}
	
	public AdminGroundlevelLawyerToken(int aL_id, String emailid, String first_name, String middle_name,
			String last_name, String phonenumber, String city, String pincode, String state, String type_of_lawyer,
			String message_to_lawyer, String appoinment_date) {
		super();
		AL_id = aL_id;
		this.emailid = emailid;
		this.first_name = first_name;
		this.middle_name = middle_name;
		this.last_name = last_name;
		this.phonenumber = phonenumber;
		this.city = city;
		this.pincode = pincode;
		this.state = state;
		this.type_of_lawyer = type_of_lawyer;
		this.message_to_lawyer = message_to_lawyer;
		this.appoinment_date = appoinment_date;
	}
	
	public int getAL_id() {
		return AL_id;
	}
	public void setAL_id(int aL_id) {
		AL_id = aL_id;
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
	public String getType_of_lawyer() {
		return type_of_lawyer;
	}
	public void setType_of_lawyer(String type_of_lawyer) {
		this.type_of_lawyer = type_of_lawyer;
	}
	public String getMessage_to_lawyer() {
		return message_to_lawyer;
	}
	public void setMessage_to_lawyer(String message_to_lawyer) {
		this.message_to_lawyer = message_to_lawyer;
	}
	public String getAppoinment_date() {
		return appoinment_date;
	}
	public void setAppoinment_date(String appoinment_date) {
		this.appoinment_date = appoinment_date;
	}	
}
