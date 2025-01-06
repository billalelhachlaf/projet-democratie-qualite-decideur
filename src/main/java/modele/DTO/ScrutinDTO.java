package modele.DTO;


import modele.Scrutin;

public class ScrutinDTO extends Scrutin {

	public int getIdProposition() {
		return idProposition;
	}

	public void setIdProposition(int idProposition) {
		this.idProposition = idProposition;
	}

	private int idProposition;

}