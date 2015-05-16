package br.com.estore.web.model;

public class UserBean {
	private String Name;
	private String CPFCNPJ;
	private String Email;
	private char Gender;
	private String Phone;
	private String CEP;
	private String Address;
	private String Neighborhood;
	private int Number;
	private String Login;
	private String Password;
	private AccessTypeBean AccessType;
	private PersonTypeBean PersonType;
	
	public UserBean(){}
	
	public UserBean(String Login, String Password){
		this.Login = Login;
		this.Password = Password;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getCPFCNPJ() {
		return CPFCNPJ;
	}
	public void setCPFCNPJ(String cPFCNPJ) {
		CPFCNPJ = cPFCNPJ;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public char getGender() {
		return Gender;
	}
	public void setGender(char gender) {
		Gender = gender;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getCEP() {
		return CEP;
	}
	public void setCEP(String cEP) {
		CEP = cEP;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getNeighborhood() {
		return Neighborhood;
	}
	public void setNeighborhood(String neighborhood) {
		Neighborhood = neighborhood;
	}
	public int getNumber() {
		return Number;
	}
	public void setNumber(int number) {
		Number = number;
	}
	public String getLogin() {
		return Login;
	}
	public void setLogin(String login) {
		Login = login;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public AccessTypeBean getAccessType() {
		return AccessType;
	}
	public void setAccessType(AccessTypeBean accessType) {
		AccessType = accessType;
	}
	public PersonTypeBean getPersonType() {
		return PersonType;
	}
	public void setPersonType(PersonTypeBean personType) {
		PersonType = personType;
	}	
}
