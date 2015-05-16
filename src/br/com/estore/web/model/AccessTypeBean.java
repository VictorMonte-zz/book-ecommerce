package br.com.estore.web.model;

public enum AccessTypeBean {
	Administrator(1),Customer(2),Seller(3);
	
    private int value;

    private AccessTypeBean(int value) {
            this.value = value;
    }
}
