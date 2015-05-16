package br.com.estore.web.model;

import java.util.Date;

public class ResumeBean {
	
	private int ID;
	private Date Date;
	private int PurchaseID;
	private String CustomerID;
	private int WishListID;
	private int ShoppingCartID;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}

	public int getPurchaseID() {
		return PurchaseID;
	}

	public void setPurchaseID(int purchaseID) {
		PurchaseID = purchaseID;
	}

	public String getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(String customerID) {
		CustomerID = customerID;
	}

	public int getWishListID() {
		return WishListID;
	}

	public void setWishListID(int wishListID) {
		WishListID = wishListID;
	}

	public int getShoppingCartID() {
		return ShoppingCartID;
	}

	public void setShoppingCartID(int shoppingCartID) {
		ShoppingCartID = shoppingCartID;
	}

}
