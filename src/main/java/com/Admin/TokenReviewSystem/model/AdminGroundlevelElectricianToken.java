package com.Admin.TokenReviewSystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AdminGroundlevelElectricianToken {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int AE_id;
	private String emailid;
	private String first_name;
	private String middle_name;
	private String last_name;
	private String phonenumber;
	private String city;
	private String pincode;
	private String state;
	private String type_of_electrician;
	private String estimated_time_of_arrival;
	private String message_to_electrician;
	
	public AdminGroundlevelElectricianToken() {
		super();
	}
	
	public AdminGroundlevelElectricianToken(int aE_id, String emailid, String first_name, String middle_name,
			String last_name, String phonenumber, String city, String pincode, String state, String type_of_electrician,
			String estimated_time_of_arrival, String message_to_electrician) {
		super();
		AE_id = aE_id;
		this.emailid = emailid;
		this.first_name = first_name;
		this.middle_name = middle_name;
		this.last_name = last_name;
		this.phonenumber = phonenumber;
		this.city = city;
		this.pincode = pincode;
		this.state = state;
		this.type_of_electrician = type_of_electrician;
		this.estimated_time_of_arrival = estimated_time_of_arrival;
		this.message_to_electrician = message_to_electrician;
	}
	public int getAE_id() {
		return AE_id;
	}
	public void setAE_id(int aE_id) {
		AE_id = aE_id;
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
	public String getType_of_electrician() {
		return type_of_electrician;
	}
	public void setType_of_electrician(String type_of_electrician) {
		this.type_of_electrician = type_of_electrician;
	}
	public String getEstimated_time_of_arrival() {
		return estimated_time_of_arrival;
	}
	public void setEstimated_time_of_arrival(String estimated_time_of_arrival) {
		this.estimated_time_of_arrival = estimated_time_of_arrival;
	}
	public String getMessage_to_electrician() {
		return message_to_electrician;
	}
	public void setMessage_to_electrician(String message_to_electrician) {
		this.message_to_electrician = message_to_electrician;
	}
}
