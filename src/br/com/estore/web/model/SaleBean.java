package br.com.estore.web.model;

import java.sql.Date;

public class SaleBean {	

	private int ID;
	private Date StartDate;
	private Date EndDate;
	private Double OffValue;
	private String Description;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Date getStartDate() {
		return StartDate;
	}

	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}

	public Date getEndDate() {
		return EndDate;
	}

	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}

	public Double getOffValue() {
		return OffValue;
	}

	public void setOffValue(Double offValue) {
		OffValue = offValue;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

}
