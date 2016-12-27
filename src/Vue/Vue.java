package Vue;

import Modele.Case;
import Modele.Couleur;
import Modele.Echiquier;
import Modele.Pion;
import Modele.Role;

/**
 * Classe qui nous permet d'afficher notre projet.
 * 
 * @author Guillaume GAUJAC
 * @version 1.0
 *
 */
public class Vue {
    /**
     * display() nous sert à afficher un échiquier que nous passons en
     * parametre.
     * 
     * @param e
     *            Un échiquier que nous afficherons.
     */
    public void display(Echiquier e) {
	System.out.print("  ");
	for (int y = 0; y < 10; y++) {
	    System.out.print(y + " ");
	}
	System.out.print("\n" + "  ");
	for (int y = 0; y < 10; y++) {
	    System.out.print("- ");
	}
	System.out.println();
	for (int i = 0; i < 10; i++) {
	    System.out.print(i + "|");
	    for (int j = 0; j < 10; j++) {
		Case c = e.getCase(i, j);
		if (c != null && c.isEnable()) {
		    Pion p = c.getPion();
		    if (p != null) {
			if (p.getRole() == Role.DRAGON && p.getCouleur() == Couleur.BLEU) {
			    couleur("d", p.getCouleur());
			}
			if (p.getRole() == Role.DRAGON && p.getCouleur() == Couleur.ROUGE) {
			    couleur("D", p.getCouleur());
			}
			if (p.getRole() == Role.SINGE && p.getCouleur() == Couleur.BLEU) {
			    couleur("s", p.getCouleur());
			}
			if (p.getRole() == Role.SINGE && p.getCouleur() == Couleur.ROUGE) {
			    couleur("S", p.getCouleur());
			    // + Couleur ROUGE
			}
			if (p.getRole() == Role.LION && p.getCouleur() == Couleur.BLEU) {
			    couleur("l", p.getCouleur());
			}
			if (p.getRole() == Role.LION && p.getCouleur() == Couleur.ROUGE) {
			    couleur("L", p.getCouleur());
			}

			if (p.getRole() == Role.BUT && p.getCouleur() == Couleur.ROUGE) {
			    couleur("B", p.getCouleur());
			}
			if (p.getRole() == Role.BUT && p.getCouleur() == Couleur.BLEU) {
			    couleur("b", p.getCouleur());
			}
		    } else {
			System.out.print(". ");
		    }
		} else {
		    System.out.print("  ");
		}
	    }
	    System.out.println();
	}
    }

    /**
     * Donne une couleur à notre affichage.
     * 
     * @param s
     *            L'affichage que l'on souhaite.
     * @param c
     *            La couleur que l'on affichera.
     */
    public void couleur(String s, Couleur c) {
	if (c == Couleur.ROUGE)
	    System.out.print((char) 27 + "[31m" + s + " " + (char) 27 + "[0m");
	if (c == Couleur.BLEU)
	    System.out.print((char) 27 + "[34m" + s + " " + (char) 27 + "[0m");
    }
}
