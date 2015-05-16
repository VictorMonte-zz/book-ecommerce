package br.com.estore.web.model;

import java.util.ArrayList;
import java.util.Date;

public class WishListBean {	

	private int ID;
	private Date Date;
	private ArrayList<BookBean> ListOfBooks;

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

	public ArrayList<BookBean> getListOfBooks() {
		return ListOfBooks;
	}

	public void setListOfBooks(ArrayList<BookBean> listOfBooks) {
		ListOfBooks = listOfBooks;
	}

}
