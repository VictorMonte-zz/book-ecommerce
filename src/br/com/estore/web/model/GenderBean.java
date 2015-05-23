package br.com.estore.web.model;

public enum GenderBean {
	
	Masculino("M"), Feminino("F");
	
	private String value;

    private GenderBean(String value) {
        this.setValue(value);
    }

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
