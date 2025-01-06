package modele;



import java.util.ArrayList;
import java.util.Date;


public class Scrutin {

	Proposition proposition;
	ArrayList<OptionScrutin> optionsScrutin = new ArrayList<>();
	ArrayList<ChoixUtilisateur> choixUtilisateurs = new ArrayList<>();
	private int idScrutin;

	public Proposition getProposition() {
		return proposition;
	}

	public void setProposition(Proposition proposition) {
		this.proposition = proposition;
	}

	public ArrayList<OptionScrutin> getOptionsScrutin() {
		return optionsScrutin;
	}

	public void setOptionsScrutin(ArrayList<OptionScrutin> optionsScrutin) {
		this.optionsScrutin = optionsScrutin;
	}

	public ArrayList<ChoixUtilisateur> getChoixUtilisateurs() {
		return choixUtilisateurs;
	}

	public void setChoixUtilisateurs(ArrayList<ChoixUtilisateur> choixUtilisateurs) {
		this.choixUtilisateurs = choixUtilisateurs;
	}

	public int getIdScrutin() {
		return idScrutin;
	}

	public void setIdScrutin(int idScrutin) {
		this.idScrutin = idScrutin;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public static ArrayList<Scrutin> getScrutins() {
		return scrutins;
	}

	public static void setScrutins(ArrayList<Scrutin> scrutins) {
		Scrutin.scrutins = scrutins;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	private String titre;
	private Date dateDebut;
	private Date dateFin;
	public static ArrayList<Scrutin> scrutins;
	private String type;

}