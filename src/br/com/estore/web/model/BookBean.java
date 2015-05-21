package br.com.estore.web.model;

public class BookBean {
	private int id;
	private String title;
	private Double value;
	private int isbn;
	private int pageNumber;
	private int year;
	private String idiom;
	private String description;
	private int authorCode;
	private int categorie;
	private int publishingHouseCode;
	private int genderCode;
	private int promotionCode;
	private int commentCode;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getIdiom() {
		return idiom;
	}

	public void setIdiom(String idiom) {
		this.idiom = idiom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAuthorCode() {
		return authorCode;
	}

	public void setAuthorCode(int authorCode) {
		this.authorCode = authorCode;
	}

	public int getCategorie() {
		return categorie;
	}

	public void setCategorie(int categorie) {
		this.categorie = categorie;
	}

	public int getPublishingHouseCode() {
		return publishingHouseCode;
	}

	public void setPublishingHouseCode(int publishingHouseCode) {
		this.publishingHouseCode = publishingHouseCode;
	}

	public int getGenderCode() {
		return genderCode;
	}

	public void setGenderCode(int genderCode) {
		this.genderCode = genderCode;
	}

	public int getPromotionCode() {
		return promotionCode;
	}

	public void setPromotionCode(int promotionCode) {
		this.promotionCode = promotionCode;
	}

	public int getCommentCode() {
		return commentCode;
	}

	public void setCommentCode(int commentCode) {
		this.commentCode = commentCode;
	}

}
