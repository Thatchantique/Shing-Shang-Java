package Test;

import java.util.InputMismatchException;
import java.util.Scanner;

import Controleur.Controleur;
import Modele.Case;
import Modele.Couleur;
import Modele.Echiquier;
import Modele.Joueur;
import Vue.Vue;

/**
 * La classe Main permet lancement d'une partie. Elle teste l'ensemble de mes
 * classes.
 * 
 * @author Guillaume GAUJAC
 * @version 1.0
 */
public class Main {
    private static Scanner sc;

    public static void main(String[] args) throws InputMismatchException {

	Echiquier e = new Echiquier(10);

	Vue v = new Vue();
	int x = 0;
	int y = 0;
	Controleur controleur = new Controleur(e, v);
	boolean tour = true;
	boolean isOver = false;
	boolean deplacementOK = true;
	Joueur j1 = new Joueur("Joueur 1", Couleur.BLEU);
	Joueur j2 = new Joueur("Joueur 2", Couleur.ROUGE);
	Joueur courant = j1;
	sc = new Scanner(System.in);

	controleur.display();

	while (!isOver) {

	    if (tour) {
		courant = j1;
	    } else {
		courant = j2;
	    }
	    deplacementOK = false;
	    while (!deplacementOK) {
		boolean estInt = false;
		while (!estInt) {
		    try {
			System.out.println("C'est le tour du " + courant.getNom() + ". Il a la couleur "
				+ courant.getCouleur() + ".");

			do {
			    System.out.println("Donnez x ou 99 pour passer votre tour.");
			    x = sc.nextInt();
			} while (x < 0 || x > 9);
			estInt = true;
		    } catch (InputMismatchException ex) {
			ex.printStackTrace();
			estInt = false;
		    } catch (ArrayIndexOutOfBoundsException ex2) {
			// A ce moment nous devrions plus avoir cette exception
			// à cause du do...while.
			// cependant, nous ne sommes jamais trop prudent.
			ex2.printStackTrace();
			estInt = false;
		    }
		    sc.nextLine();
		}
		if (x != 99) {
		    estInt = false;
		    while (!estInt) {
			try {
			    do {
				System.out.println("Donnez y.");
				y = sc.nextInt();
			    } while (y < 0 || y > 9);
			    estInt = true;
			} catch (InputMismatchException ex1) {
			    ex1.printStackTrace();
			    estInt = false;
			} catch (ArrayIndexOutOfBoundsException ex2) {
			    // Même chose que pour le x. Nous devrions plus
			    // avoir cette exception mais je la laisse par
			    // sureté.
			    ex2.printStackTrace();
			    estInt = false;

			}
			sc.nextLine();
		    }
		    Case c1 = new Case(x, y);
		    System.out.println("Où souhaitez-vous déplacer ce pion ?");
		    System.out.println("Donnez x.");
		    x = sc.nextInt();
		    System.out.println("Donnez y.");
		    y = sc.nextInt();
		    Case c2 = new Case(x, y);
		    deplacementOK = controleur.deplacerContenusCase(c1, c2, courant);
		    if (deplacementOK && !controleur.isShingShang()) {
			tour = !tour;
		    }
		} else {
		    System.out.println("Je passe mon tour");
		    tour = !tour;
		    deplacementOK = true;
		}
		controleur.display();
	    }
	    isOver = controleur.estGagner(courant);
	}
	Couleur pCouleur = controleur.getCouleurGagner();
	if (j1.getCouleur() == pCouleur) {
	    System.out.println(j1.getNom() + " a gagné");
	} else {
	    System.out.println(j2.getNom() + " a gagné");
	}

    }
}