package br.com.estore.web.model;

import java.util.Date;

public class PromotionBean {
	
	private int id;
	private String description;
	private Date initialDate;
	private Date endDate;
	private String typeDiscount;
	private double discountValue;
	
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
	public Date getInitialDate() {
		return initialDate;
	}
	public void setInitialDate(Date initialDate) {
		this.initialDate = initialDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getTypeDiscount() {
		return typeDiscount;
	}
	public void setTypeDiscount(String typeDiscount) {
		this.typeDiscount = typeDiscount;
	}
	public double getDiscountValue() {
		return discountValue;
	}
	public void setDiscountValue(double discountValue) {
		this.discountValue = discountValue;
	}
	

}
