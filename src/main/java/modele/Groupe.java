package modele;


import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.ArrayList;

public class Groupe {

	ArrayList<Proposition> propositions = new ArrayList<>();
	ArrayList<Theme> themes = new ArrayList<>();
	private int idGroupe;
	private String nom;
	private float limiteBudgetAnnuel;
	private int nbMembres;
	private String desc;

	public String getDesc() {
		return desc;
	}

	public ArrayList<Proposition> getPropositions() {
		return propositions;
	}

	public void setPropositions(ArrayList<Proposition> propositions) {
		this.propositions = propositions;
	}

	public ArrayList<Theme> getThemes() {
		return themes;
	}

	public void setThemes(ArrayList<Theme> themes) {
		this.themes = themes;
	}

	public int getIdGroupe() {
		return idGroupe;
	}

	public void setIdGroupe(int idGroupe) {
		this.idGroupe = idGroupe;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public float getLimiteBudgetAnnuel() {
		return limiteBudgetAnnuel;
	}

	public void setLimiteBudgetAnnuel(float limiteBudgetAnnuel) {
		this.limiteBudgetAnnuel = limiteBudgetAnnuel;
	}

	public int getNbMembres() {
		return nbMembres;
	}

	public void setNbMembres(int nbMembres) {
		this.nbMembres = nbMembres;
	}

	public static Groupe getGroupe() {
		return groupe;
	}

	public static String getGroupeFromApi(int idGroupe)  {

        Connection.Response response = null;
        try {
            response = Jsoup.connect(ApiURL.URL+"/api/decideurs/groupes/"+idGroupe)
					.ignoreContentType(true)
					.method(Connection.Method.GET)
                    .execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return response.body();

	}

	public static void setGroupe(Groupe groupe) {
		Groupe.groupe = groupe;
	}

	public static Groupe groupe;

	public int modifierBudget(float budget){
		try {
			Connection.Response response = Jsoup.connect(ApiURL.URL+"/api/decideurs/groupes/" + this.getIdGroupe() + "/budget")
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