package Controleur;

import Modele.Case;
import Modele.Couleur;
import Modele.Echiquier;
import Modele.Joueur;
import Vue.Vue;

/**
 * Classe sollicitant l’utilisateur. Elle permet la synchronisation du modèle et
 * de la vue. Elle s'apparente à un écouteur d'événement.
 * 
 * @author Guillaume GAUJAC
 * @version 1.0
 * 
 */
public class Controleur implements Gestion {

    private Echiquier echiquier;
    private Vue vue;

    /**
     * Le contrôleur aura besoin d'un échiquier et dans le but des les modifier
     * ultérieurement.
     * 
     * @param e
     *            L'echiquier de notre partie
     * @param v
     *            La vue nous permettant d'afficher le plateau.
     */
    public Controleur(Echiquier e, Vue v) {
	echiquier = e;
	vue = v;
    }

    /**
     * La méthode deplacerConenusCase de la classe Contrôleur sert à tester la
     * couleur du joueur courant et de la case initiale. Si la case est de la
     * même couleur que le joueur elle appelle la méthode deplacerConenusCase de
     * la classe Échiquier dans le but de déplacer le pion.
     * 
     * @param c1
     *            La case courante : où se trouve le pion que l'on souhaite
     *            déplacer.
     * @param c2
     *            La case où on souhaite déplacer notre pion.
     * @param j1
     *            Le joueur courant : celui qui est entrain de jouer.
     * @return Faux si la couleur du joueur n'est pas la même que celle du pion
     *         positionné en c1. Sinon voir si deplacerContenusCase de Echiquier
     *         se fait bien.
     */
    @Override
    public boolean deplacerContenusCase(Case c1, Case c2, Joueur j1) {
	if (j1.getCouleur() == echiquier.getCouleur(c1)) {
	    return echiquier.deplacerContenusCase(c1, c2);
	}
	return false;
    }

    /**
     * La méthode display du Contrôleur appelle la méthode display de la vue.
     */
    public void display() {
	vue.display(echiquier);
    }

    /**
     * Initialiser l'echiquier.
     * 
     * @param e1
     *            L'echiquier que nous utilisons.
     */
    public void registreEchiquier(Echiquier e1) {
	echiquier = e1;
    }

    /**
     * Fait la liaison avec estGagner de Echiquier en vérifiant si l'opération
     * se déroule bien.
     * 
     * @param courant
     *            Le joueur qui est entrain de jouer.
     * @return Verifier si estGagner de Echiquier se fait bien.
     */
    public boolean estGagner(Joueur courant) {
	return echiquier.estGagner(courant);
    }

    /**
     * Retourne la couleur du gagnant.
     * 
     * @return La couleur du gagnant.
     */
    public Couleur getCouleurGagner() {
	return echiquier.getCouleurGagner();
    }

    /**
     * Elle vérifie si on a un Shing-Shang lors d'un tour en retourne un
     * boolean.
     * 
     * @return False : Il n'y a pas de Shing-Shang lors d'un tour. True : Il y
     *         en a un.
     */
    public boolean isShingShang() {
	return echiquier.isShingShang();
    }

}
