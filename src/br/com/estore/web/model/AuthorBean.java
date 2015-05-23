package br.com.estore.web.model;

import java.util.Date;

public class AuthorBean {

	private Long id;
	private String nome;
	private String telefone;
	private String cpf;
	private GenderBean gender;
	private String email;
	private Date birthDate;
	private NacionalityBean nacionality;
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public GenderBean getGender() {
		return gender;
	}

	public void setGender(GenderBean gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public NacionalityBean getNacionality() {
		return nacionality;
	}

	public void setNacionality(NacionalityBean nacionality) {
		this.nacionality = nacionality;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
