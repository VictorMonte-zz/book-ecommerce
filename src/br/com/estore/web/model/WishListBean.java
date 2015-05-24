package br.com.estore.web.model;

import java.util.Date;

public class WishListBean {

	// ID_LIST INT NOT NULL AUTO_INCREMENT ,
	// DATE_WISH_LIST DATE NOT NULL ,
	// CUSTOMER_ID INT NOT NULL ,
	// ID_BOOK INT NOT NULL ,

	private int id;
	private Date date;
	private int customerID;
	private int bookID;

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

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

}
