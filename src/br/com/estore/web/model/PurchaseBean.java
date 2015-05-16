package br.com.estore.web.model;

import java.util.Date;

public class PurchaseBean {
	
	private int ID;
	private int ShoppingCartID;
	private int CustomerID;
	private int WishListID;
	private Double Total;
	private Date Date;
	private PaymentTypeBean PaymentType;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getShoppingCartID() {
		return ShoppingCartID;
	}

	public void setShoppingCartID(int shoppingCartID) {
		ShoppingCartID = shoppingCartID;
	}

	public int getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}

	public int getWishListID() {
		return WishListID;
	}

	public void setWishListID(int wishListID) {
		WishListID = wishListID;
	}

	public Double getTotal() {
		return Total;
	}

	public void setTotal(Double total) {
		Total = total;
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}

	public PaymentTypeBean getPaymentType() {
		return PaymentType;
	}

	public void setPaymentType(PaymentTypeBean paymentType) {
		PaymentType = paymentType;
	}

}
