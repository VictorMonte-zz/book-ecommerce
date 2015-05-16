package br.com.estore.web.model;

public class PublishingHouseBean {
	
	private int ID;
	private String Name;
	private String Email;
	private String Telefone;
	private String Contact;
	private String CNPJ;
	private String IE;
	private String Site;
	private char Type;
	private String SocialReason;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getTelefone() {
		return Telefone;
	}

	public void setTelefone(String telefone) {
		Telefone = telefone;
	}

	public String getContact() {
		return Contact;
	}

	public void setContact(String contact) {
		Contact = contact;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}

	public String getIE() {
		return IE;
	}

	public void setIE(String iE) {
		IE = iE;
	}

	public String getSite() {
		return Site;
	}

	public void setSite(String site) {
		Site = site;
	}

	public char getType() {
		return Type;
	}

	public void setType(char type) {
		Type = type;
	}

	public String getSocialReason() {
		return SocialReason;
	}

	public void setSocialReason(String socialReason) {
		SocialReason = socialReason;
	}

}
