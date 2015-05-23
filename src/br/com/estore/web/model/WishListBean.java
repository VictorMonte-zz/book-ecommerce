package br.com.estore.web.model;

import java.util.ArrayList;
import java.util.Date;

public class WishListBean {

	private int id;
	private Date date;
	private ArrayList<BookBean> listOfBooks;

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

	public ArrayList<BookBean> getListOfBooks() {
		return listOfBooks;
	}

	public void setListOfBooks(ArrayList<BookBean> listOfBooks) {
		this.listOfBooks = listOfBooks;
	}

}
