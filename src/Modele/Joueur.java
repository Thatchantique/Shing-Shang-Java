package Modele;

public class Joueur {

    protected String Nom;
    protected Couleur couleur;

    public Joueur(String n, Couleur c) {
	Nom = n;
	couleur = c;
    }

    public String getNom() {
	return Nom;
    }

    public Couleur getCouleur() {
	return couleur;
    }
}
