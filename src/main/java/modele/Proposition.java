package modele;


import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;


public class Proposition {

	ArrayList<Scrutin> scrutins = new ArrayList<>();
	Groupe groupe;

	public ArrayList<Scrutin> getScrutins() {
		return scrutins;
	}

	public void setScrutins(ArrayList<Scrutin> scrutins) {
		this.scrutins = scrutins;
	}

	public Groupe getGroupe() {
		return groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public int getIdProposition() {
		return idProposition;
	}

	public void setIdProposition(int idProposition) {
		this.idProposition = idProposition;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public float getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(float evaluation) {
		this.evaluation = evaluation;
	}

	public static ArrayList<Proposition> getPropositions() {
		return propositions;
	}

	public static void setPropositions(ArrayList<Proposition> propositions) {
		Proposition.propositions = propositions;
	}

	Theme theme;
	private int idProposition;
	private String titre;
	private Date date;
	private float evaluation;
	public static ArrayList<Proposition> propositions;

	public int modifierEvaluation(float evaluation){
		try {
			Connection.Response response = Jsoup.connect(ApiURL.URL+"/api/decideurs/propositions/" + this.getIdProposition() + "/evaluation")
					.header("Content-Type", "application/json")
					.header("Accept", "application/json")
					.requestBody("{\"evaluation\":" + evaluation + "}")
					.ignoreContentType(true)
					.method(Connection.Method.POST)
					.execute();
			return response.statusCode();

		} catch (IOException e) {
			return 500;
		}


	}

}