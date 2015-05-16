package br.com.estore.web.model;

public enum PaymentTypeBean {
	
	CartaoDebito(1, "Cartao de Debito"), CartaoCredito(1, "Cartao de Credito"), Dinheiro(
			2, "Dinheiro");

	private int ID;
	private String Description;

	private PaymentTypeBean(int ID, String Description) {
		this.ID = ID;
		this.Description = Description;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

}
