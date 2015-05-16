package br.com.estore.web.model;

public enum ComplainType {
	Duvida(1),Reclamacao(2),Sugestao(3);
	
    private int ID;

    private ComplainType(int ID) {
    	this.ID = ID;
    }

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

}
