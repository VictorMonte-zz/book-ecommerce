package br.com.estore.web.model;

import java.util.Date;

public class ShoppingCartBean {

	// DATE_SHOPPING_CART DATE ,
	// QUANTIDADE INT ,
	// ID_BOOK INT NOT NULL ,
	// CUSTOMER_ID INT NOT NULL

	private Date dateShopping;
	private int quantidade;
	private int bookID;
	private int customerID;

	public Date getDateShopping() {
		return dateShopping;
	}

	public void setDateShopping(Date dateShopping) {
		this.dateShopping = dateShopping;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
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
