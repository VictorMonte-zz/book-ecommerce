package br.com.estore.web.model;

public class BookBean {
	private int ID;
	private String Title;
	private Double Value;
	private int ISBN;
	private int PageNumber;
	private int Year;
	private String Idiom;
	private String Description;
	private int AuthorCode;	
	private int Categorie;	
	private int PublishingHouseCode;	  
	private int GenderCode;	  
	private int PromotionCode;	  
	private int CommentCode;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public Double getValue() {
		return Value;
	}
	public void setValue(Double value) {
		Value = value;
	}
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}
	public int getPageNumber() {
		return PageNumber;
	}
	public void setPageNumber(int pageNumber) {
		PageNumber = pageNumber;
	}
	public int getYear() {
		return Year;
	}
	public void setYear(int year) {
		Year = year;
	}
	public String getIdiom() {
		return Idiom;
	}
	public void setIdiom(String idiom) {
		Idiom = idiom;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public int getAuthorCode() {
		return AuthorCode;
	}
	public void setAuthorCode(int authorCode) {
		AuthorCode = authorCode;
	}
	public int getCategorie() {
		return Categorie;
	}
	public void setCategorie(int categorie) {
		Categorie = categorie;
	}
	public int getPublishingHouseCode() {
		return PublishingHouseCode;
	}
	public void setPublishingHouseCode(int publishingHouseCode) {
		PublishingHouseCode = publishingHouseCode;
	}
	public int getGenderCode() {
		return GenderCode;
	}
	public void setGenderCode(int genderCode) {
		GenderCode = genderCode;
	}
	public int getPromotionCode() {
		return PromotionCode;
	}
	public void setPromotionCode(int promotionCode) {
		PromotionCode = promotionCode;
	}
	public int getCommentCode() {
		return CommentCode;
	}
	public void setCommentCode(int commentCode) {
		CommentCode = commentCode;
	}
	
	
}
