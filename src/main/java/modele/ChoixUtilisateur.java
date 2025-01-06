package modele;



import java.util.ArrayList;


public class ChoixUtilisateur {

	Scrutin scrutin;
	OptionScrutin optionScrutin;
	private String idUtilisateur;
	private int classement;
	private int idChoixUtilisateur;

	public Scrutin getScrutin() {
		return scrutin;
	}

	public void setScrutin(Scrutin scrutin) {
		this.scrutin = scrutin;
	}

	public OptionScrutin getOptionScrutin() {
		return optionScrutin;
	}

	public void setOptionScrutin(OptionScrutin optionScrutin) {
		this.optionScrutin = optionScrutin;
	}

	public String getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(String idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public int getClassement() {
		return classement;
	}

	public void setClassement(int classement) {
		this.classement = classement;
	}

	public int getIdChoixUtilisateur() {
		return idChoixUtilisateur;
	}

	public void setIdChoixUtilisateur(int idChoixUtilisateur) {
		this.idChoixUtilisateur = idChoixUtilisateur;
	}

	public static ArrayList<ChoixUtilisateur> getChoixUtilisateurs() {
		return choixUtilisateurs;
	}

	public static void setChoixUtilisateurs(ArrayList<ChoixUtilisateur> choixUtilisateurs) {
		ChoixUtilisateur.choixUtilisateurs = choixUtilisateurs;
	}

	public static ArrayList<ChoixUtilisateur> choixUtilisateurs;

}