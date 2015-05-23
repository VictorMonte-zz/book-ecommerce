package br.com.estore.web.model;

public enum PaymentTypeBean {

	CartaoDebito(1, "Cartao de Debito"), CartaoCredito(2, "Cartao de Credito"), Dinheiro(
			3, "Dinheiro");

	private int id;
	private String description;

	private PaymentTypeBean(int id, String description) {
		this.id = id;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
