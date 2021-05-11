package com.TokenReviewSystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LawyerTokenData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int L_id;
	private String emailID;
	private String type_of_lawyer;
	private String message_to_lawyer;
	private String appoinment_date;
	
	public LawyerTokenData() {
		super();
	}
	public LawyerTokenData(int l_id, String emailID, String type_of_lawyer, String message_to_lawyer,
			String appoinment_date) {
		super();
		L_id = l_id;
		this.emailID = emailID;
		this.type_of_lawyer = type_of_lawyer;
		this.message_to_lawyer = message_to_lawyer;
		this.appoinment_date = appoinment_date;
	}
	public int getL_id() {
		return L_id;
	}
	public void setL_id(int l_id) {
		L_id = l_id;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
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
