package br.com.estore.web.model;

public enum PersonTypeBean {
	Individuals(1),legalEntity(2);
	
    private int value;

    private PersonTypeBean(int value) {
            this.value = value;
    }
}
