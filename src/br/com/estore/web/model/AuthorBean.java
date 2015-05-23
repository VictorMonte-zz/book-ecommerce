package br.com.estore.web.model;

public class AuthorBean {

	private int ID;
	private String Nome;
	private String Telefone;
	private String CPF;
	private GenderBean Gender;
	private String Email;
	private int Age;
	private NacionalityBean Nacionality;
	private String Description;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getTelefone() {
		return Telefone;
	}

	public void setTelefone(String telefone) {
		Telefone = telefone;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public GenderBean getGender() {
		return Gender;
	}

	public void setGender(GenderBean gender) {
		Gender = gender;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public NacionalityBean getNacionality() {
		return Nacionality;
	}

	public void setNacionality(NacionalityBean nacionality) {
		Nacionality = nacionality;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

}
