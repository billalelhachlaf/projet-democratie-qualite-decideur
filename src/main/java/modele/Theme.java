package modele;


import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.ArrayList;

public class Theme {

	Groupe groupe;
	ArrayList<Proposition> propositions = new ArrayList<>();
	private int idTheme;

	public Groupe getGroupe() {
		return groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}

	public ArrayList<Proposition> getPropositions() {
		return propositions;
	}

	public void setPropositions(ArrayList<Proposition> propositions) {
		this.propositions = propositions;
	}

	public int getIdTheme() {
		return idTheme;
	}

	public void setIdTheme(int idTheme) {
		this.idTheme = idTheme;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public float getLimiteBudget() {
		return limiteBudget;
	}

	public void setLimiteBudget(float limiteBudget) {
		this.limiteBudget = limiteBudget;
	}

	public static ArrayList<Theme> getThemes() {
		return themes;
	}

	public static void setThemes(ArrayList<Theme> themes) {
		Theme.themes = themes;
	}

	private String nom;
	private float limiteBudget;
	public static ArrayList<Theme> themes;

	public int modifierBudget(float budget){
		try {
			Connection.Response response = Jsoup.connect(ApiURL.URL+"/api/decideurs/themes/" + this.getIdTheme() + "/budget")
					.header("Content-Type", "application/json")
					.header("Accept", "application/json")
					.requestBody("{\"limiteBudget\":" + budget + "}")
					.ignoreContentType(true)
					.method(Connection.Method.POST)
					.execute();
			return response.statusCode();

		} catch (IOException e) {
			return 500;
		}

	}
}