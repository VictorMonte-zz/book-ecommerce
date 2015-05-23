package br.com.estore.web.model;

public enum GenderBean {
	Masculino('M'),Feminino('F');
	
	private int value;

    private GenderBean(int value) {
            this.setValue(value);
    }

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
