package br.com.estore.web.model;

public class UserBean {
	private String name;
	private String cpfcnpj;
	private String email;
	private char gender;
	private String phone;
	private String cep;
	private String street;
	private String neighborhood;
	private int number;
	private String login;
	private String password;
	private AccessTypeBean accessType;
	private PersonTypeBean personType;
	
	public UserBean(){}
	
	public UserBean(String login, String password){
		this.login = login;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpfcnpj() {
		return cpfcnpj;
	}

	public void setCpfcnpj(String cpfcnpj) {
		this.cpfcnpj = cpfcnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
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

	public AccessTypeBean getAccessType() {
		return accessType;
	}

	public void setAccessType(AccessTypeBean accessType) {
		this.accessType = accessType;
	}

	public PersonTypeBean getPersonType() {
		return personType;
	}

	public void setPersonType(PersonTypeBean personType) {
		this.personType = personType;
	}
	
	
}
