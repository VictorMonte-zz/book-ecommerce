package br.com.estore.web.model;

public class CustomerBean {
	/*
	 * ID INT NOT NULL AUTO_INCREMENT , IS_ADMIN INT NOT NULL, LOGIN VARCHAR
	 * (40) , PASSWORD VARCHAR (10) , NAME VARCHAR (100) , EMAIL VARCHAR (150) ,
	 * GENDER VARCHAR (9) , PHONNE VARCHAR (9) , ADDRESS VARCHAR (200),
	 */

	private int id;
	private int is_admin;
	private String login;
	private String password;
	private String name;
	private String email;
	private String gender;
	private String phone;
	private String Address;

	public CustomerBean() {
	}

	public CustomerBean(String pLogin, String pPassword) {
		this.login = pLogin;
		this.password  = pPassword;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIs_admin() {
		return is_admin;
	}

	public void setIs_admin(int is_admin) {
		this.is_admin = is_admin;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

}
