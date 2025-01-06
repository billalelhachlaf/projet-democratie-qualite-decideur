package modele.DTO;


import modele.ChoixUtilisateur;

public class ChoixUtilisateurDTO extends ChoixUtilisateur {

	private int idOptionScrutin;
	private int idScrutin;

	public int getIdOptionScrutin() {
		return idOptionScrutin;
	}

	public void setIdOptionScrutin(int idOptionScrutin) {
		this.idOptionScrutin = idOptionScrutin;
	}

	public int getIdScrutin() {
		return idScrutin;
	}

	public void setIdScrutin(int idScrutin) {
		this.idScrutin = idScrutin;
	}
}