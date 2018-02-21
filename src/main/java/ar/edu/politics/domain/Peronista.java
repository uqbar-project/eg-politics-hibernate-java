package ar.edu.politics.domain;

public class Peronista extends Partido {
	
	private static final long serialVersionUID = 5597365785136318369L;

	boolean populista;

	public boolean isPopulista() {
		return populista;
	}

	public void setPopulista(boolean populista) {
		this.populista = populista;
	}

}
