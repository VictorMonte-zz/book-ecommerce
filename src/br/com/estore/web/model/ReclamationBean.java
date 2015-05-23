package br.com.estore.web.model;

import java.util.Date;

public class ReclamationBean {

	private int id;
	private String description;
	private Date date;
	private ComplainType complainType;
	private String customerID;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public ComplainType getComplainType() {
		return complainType;
	}

	public void setComplainType(ComplainType complainType) {
		this.complainType = complainType;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

}
