package br.com.estore.web.model;

public class BookBean {

	/*
	 * ID_BOOK INT NOT NULL , TITLE BLOB , PRICE FLOAT , ISBN INT , NUMBER_PAGES
	 * INT , DESCRIPTION VARCHAR (300) , IMAGE_DIRETORY VARCHAR (500) , LIKEBOOK
	 * INT , ID_AUTHOR INT NOT NULL , ID_PUBLISHING_HOUSE INT NOT NULL ,
	 * ID_CATEGORY INT NOT NULL
	 */

	private int id;
	private String title;
	private Double price;
	private int isbn;
	private int numerPages;
	private String description;
	private String imageDirectory;
	private int likebook;
	private int authorId;
	private int publishingHouseId;
	private int categoryId;	
		

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public int getNumerPages() {
		return numerPages;
	}

	public void setNumerPages(int numerPages) {
		this.numerPages = numerPages;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageDirectory() {
		return imageDirectory;
	}

	public void setImageDirectory(String imageDirectory) {
		this.imageDirectory = imageDirectory;
	}

	public int getLikebook() {
		return likebook;
	}

	public void setLikebook(int likebook) {
		this.likebook = likebook;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public int getPublishingHouseId() {
		return publishingHouseId;
	}

	public void setPublishingHouseId(int publishingHouseId) {
		this.publishingHouseId = publishingHouseId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

}
