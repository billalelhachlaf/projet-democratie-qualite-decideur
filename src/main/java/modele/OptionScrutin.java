package modele;


import java.util.ArrayList;


public class OptionScrutin {

	Scrutin scrutin;
	ArrayList<ChoixUtilisateur> choixUtilisateurs = new ArrayList<>();
	private int idOptionScrutin;

	public Scrutin getScrutin() {
		return scrutin;
	}

	public void setScrutin(Scrutin scrutin) {
		this.scrutin = scrutin;
	}

	public ArrayList<ChoixUtilisateur> getChoixUtilisateurs() {
		return choixUtilisateurs;
	}

	public void setChoixUtilisateurs(ArrayList<ChoixUtilisateur> choixUtilisateurs) {
		this.choixUtilisateurs = choixUtilisateurs;
	}

	public int getIdOptionScrutin() {
		return idOptionScrutin;
	}

	public void setIdOptionScrutin(int idOptionScrutin) {
		this.idOptionScrutin = idOptionScrutin;
	}

	public String getOptionScrutin() {
		return optionScrutin;
	}

	public void setOptionScrutin(String optionScrutin) {
		this.optionScrutin = optionScrutin;
	}

	public static ArrayList<OptionScrutin> getOptionScrutins() {
		return optionScrutins;
	}

	public static void setOptionScrutins(ArrayList<OptionScrutin> optionScrutins) {
		OptionScrutin.optionScrutins = optionScrutins;
	}

	private String optionScrutin;
	public static ArrayList<OptionScrutin> optionScrutins;

}