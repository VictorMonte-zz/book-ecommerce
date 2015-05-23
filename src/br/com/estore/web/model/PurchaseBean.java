package br.com.estore.web.model;

import java.util.Date;

public class PurchaseBean {

	private int id;
	private int shoppingCartID;
	private int customerID;
	private int wishListID;
	private Double total;
	private Date date;
	private PaymentTypeBean paymentType;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getShoppingCartID() {
		return shoppingCartID;
	}

	public void setShoppingCartID(int shoppingCartID) {
		this.shoppingCartID = shoppingCartID;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public int getWishListID() {
		return wishListID;
	}

	public void setWishListID(int wishListID) {
		this.wishListID = wishListID;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public PaymentTypeBean getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentTypeBean paymentType) {
		this.paymentType = paymentType;
	}

}
