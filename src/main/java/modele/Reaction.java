package modele;


import java.util.ArrayList;
import java.util.Date;


public class Reaction {
    public int getIdReaction() {
        return idReaction;
    }

    public String getValeur() {
        return valeur;
    }

    public String getIdUtilisateur() {
        return idUtilisateur;
    }

    public static ArrayList<Reaction> getReactions() {
        return reactions;
    }

    int idReaction;
    String valeur;
    String idUtilisateur;

    public static ArrayList<Reaction> reactions;



}