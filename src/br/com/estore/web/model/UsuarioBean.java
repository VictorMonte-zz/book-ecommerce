package br.com.estore.web.model;

public class UsuarioBean {
	private String Nome;
	private String CPF_CNPJ;
	private String Email;
	private char Sexo;
	private String Telefone;
	private String CEP;
	private String Rua;
	private String Bairro;
	private String Numero;
	private String Login;
	private String Senha;	
	private String TP_ACESSO_ID_TP_ACESSO;
	private String TP_PESSOA_ID_TP;
	
	public UsuarioBean()
	{
		
	}
	
	public UsuarioBean(String login, String senha)
	{
		this.Login = login;
		this.Senha = senha;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCPF_CNPJ() {
		return CPF_CNPJ;
	}

	public void setCPF_CNPJ(String cPF_CNPJ) {
		CPF_CNPJ = cPF_CNPJ;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public char getSexo() {
		return Sexo;
	}

	public void setSexo(char sexo) {
		Sexo = sexo;
	}

	public String getTelefone() {
		return Telefone;
	}

	public void setTelefone(String telefone) {
		Telefone = telefone;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}

	public String getRua() {
		return Rua;
	}

	public void setRua(String rua) {
		Rua = rua;
	}

	public String getBairro() {
		return Bairro;
	}

	public void setBairro(String bairro) {
		Bairro = bairro;
	}

	public String getNumero() {
		return Numero;
	}

	public void setNumero(String numero) {
		Numero = numero;
	}

	public String getLogin() {
		return Login;
	}

	public void setLogin(String login) {
		Login = login;
	}

	public String getSenha() {
		return Senha;
	}

	public void setSenha(String senha) {
		Senha = senha;
	}

	public String getTP_ACESSO_ID_TP_ACESSO() {
		return TP_ACESSO_ID_TP_ACESSO;
	}

	public void setTP_ACESSO_ID_TP_ACESSO(String tP_ACESSO_ID_TP_ACESSO) {
		TP_ACESSO_ID_TP_ACESSO = tP_ACESSO_ID_TP_ACESSO;
	}

	public String getTP_PESSOA_ID_TP() {
		return TP_PESSOA_ID_TP;
	}

	public void setTP_PESSOA_ID_TP(String tP_PESSOA_ID_TP) {
		TP_PESSOA_ID_TP = tP_PESSOA_ID_TP;
	}	
	
	
	
}
