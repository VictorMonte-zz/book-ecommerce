package br.com.estore.web.model;

import java.util.Date;

public class PurchaseBean {

	/*
	 * PURCHASE_ID INT NOT NULL AUTO_INCREMENT , PURCHASE_DATE DATE , TOTAL
	 * DOUBLE, ID_PROMOTION INT NOT NULL , ID_BOOK INT NOT NULL , CUSTOMER_ID
	 * INT,
	 */

	private int id;
	private Date date;
	private Double total;
	private int promotionID;
	private int bookID;
	private int customerID;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public int getPromotionID() {
		return promotionID;
	}

	public void setPromotionID(int promotionID) {
		this.promotionID = promotionID;
	}

	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

}
