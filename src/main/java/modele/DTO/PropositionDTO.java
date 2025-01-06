package modele.DTO;


import modele.Proposition;

public class PropositionDTO extends Proposition {

	private int idTheme;
	private int idGroupe;

	public int getIdTheme() {
		return idTheme;
	}

	public void setIdTheme(int idTheme) {
		this.idTheme = idTheme;
	}

	public int getIdGroupe() {
		return idGroupe;
	}

	public void setIdGroupe(int idGroupe) {
		this.idGroupe = idGroupe;
	}
}