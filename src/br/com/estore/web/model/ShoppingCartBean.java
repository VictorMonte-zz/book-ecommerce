package br.com.estore.web.model;

import java.util.ArrayList;

public class ShoppingCartBean {	

	private int ID;
	private String CPFCNPJ;
	private ArrayList<BookBean> ListOfBooks;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getCPFCNPJ() {
		return CPFCNPJ;
	}

	public void setCPFCNPJ(String cPFCNPJ) {
		CPFCNPJ = cPFCNPJ;
	}

	public ArrayList<BookBean> getListOfBooks() {
		return ListOfBooks;
	}

	public void setListOfBooks(ArrayList<BookBean> listOfBooks) {
		ListOfBooks = listOfBooks;
	}

}
