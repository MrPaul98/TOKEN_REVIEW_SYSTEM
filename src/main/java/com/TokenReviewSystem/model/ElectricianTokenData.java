package com.TokenReviewSystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ElectricianTokenData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int E_id;
	private String emailID;
	private String type_of_electrician;
	private String estimated_time_of_arrival;
	private String message_to_electrician;
	
	public ElectricianTokenData() {
		super();
	}
	public ElectricianTokenData(int e_id, String emailID, String type_of_electrician, String estimated_time_of_arrival,
			String message_to_electrician) {
		super();
		E_id = e_id;
		this.emailID = emailID;
		this.type_of_electrician = type_of_electrician;
		this.estimated_time_of_arrival = estimated_time_of_arrival;
		this.message_to_electrician = message_to_electrician;
	}
	public int getE_id() {
		return E_id;
	}
	public void setE_id(int e_id) {
		E_id = e_id;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
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
