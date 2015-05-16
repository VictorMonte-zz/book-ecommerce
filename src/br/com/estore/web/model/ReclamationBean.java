package br.com.estore.web.model;

import java.util.Date;

public class ReclamationBean {
	
	private int ID;
	private String Description;
	private Date Date;
	private ComplainType ComplainType;
	private String CustomerCPF;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}

	public ComplainType getComplainType() {
		return ComplainType;
	}

	public void setComplainType(ComplainType complainType) {
		ComplainType = complainType;
	}

	public String getCustomerCPF() {
		return CustomerCPF;
	}

	public void setCustomerCPF(String customerCPF) {
		CustomerCPF = customerCPF;
	}

}
