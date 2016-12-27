package Modele;

/**
 * 
 * @author Guillaume GAUJAC
 * @version 1.0
 *
 */

public class Echiquier {

    private Case[][] Plateau;
    private int taille;
    private Couleur Gagnant;
    private boolean SShang;

    /**
     * Constructeur de l'objet : Echiquier
     * 
     * @param t La taille de notre échiquier.
     */
    public Echiquier(int t) {
	Gagnant = Couleur.VIDE;
	taille = t;
	Plateau = new Case[t][t];
	SShang = false;
	for (int i = 0; i < t; i++) {
	    for (int j = 0; j < t; j++)
		Plateau[i][j] = new Case();
	}

	/* Equipe Rouge */
	Plateau[0][1].setPion(new Dragon(Couleur.ROUGE));
	Plateau[0][8].setPion(new Dragon(Couleur.ROUGE));

	Plateau[0][2].setPion(new Lion(Couleur.ROUGE));
	Plateau[0][7].setPion(new Lion(Couleur.ROUGE));
	Plateau[1][1].setPion(new Lion(Couleur.ROUGE));
	Plateau[1][8].setPion(new Lion(Couleur.ROUGE));

	Plateau[0][3].setPion(new Singe(Couleur.ROUGE));
	Plateau[0][6].setPion(new Singe(Couleur.ROUGE));
	Plateau[1][2].setPion(new Singe(Couleur.ROUGE));
	Plateau[1][7].setPion(new Singe(Couleur.ROUGE));
	Plateau[2][1].setPion(new Singe(Couleur.ROUGE));
	Plateau[2][8].setPion(new Singe(Couleur.ROUGE));

	Plateau[1][5].setPion(new Portail(Couleur.ROUGE));
	Plateau[1][4].setPion(new Portail(Couleur.ROUGE));

	/* Equipe Bleue */

	Plateau[9][1].setPion(new Dragon(Couleur.BLEU));
	Plateau[9][8].setPion(new Dragon(Couleur.BLEU));

	Plateau[9][2].setPion(new Lion(Couleur.BLEU));
	Plateau[9][7].setPion(new Lion(Couleur.BLEU));
	Plateau[8][1].setPion(new Lion(Couleur.BLEU));
	Plateau[8][8].setPion(new Lion(Couleur.BLEU));

	Plateau[9][3].setPion(new Singe(Couleur.BLEU));
	Plateau[9][6].setPion(new Singe(Couleur.BLEU));
	Plateau[8][2].setPion(new Singe(Couleur.BLEU));
	Plateau[8][7].setPion(new Singe(Couleur.BLEU));
	Plateau[7][1].setPion(new Singe(Couleur.BLEU));
	Plateau[7][8].setPion(new Singe(Couleur.BLEU));

	Plateau[8][5].setPion(new Portail(Couleur.BLEU));
	Plateau[8][4].setPion(new Portail(Couleur.BLEU));

	/* Insertion des cases inaccessibles */
	for (int i = 0; i < 4; i++) {
	    Plateau[i][0].setDisable();
	    Plateau[i][9].setDisable();

	    Plateau[i + 6][0].setDisable();
	    Plateau[i + 6][9].setDisable();
	}
    }

    public Pion getPion(int x, int y) {
	return Plateau[x][y].getPion();
    }

    public Case getCase(int x, int y) {
	return Plateau[x][y];
    }

    public boolean deplacerContenusCase(Case c1, Case c2) {
	SShang = false;
	// System.out.println("Je suis dans la méthode");
	int x1, y1, x2, y2;
	x1 = c1.getX();
	y1 = c1.getY();
	x2 = c2.getX();
	y2 = c2.getY();
	if (c1 != null && c1.isInsideTable(taille)) {
	    // System.out.println("C1 est dans le tableau");
	    if (!Plateau[x1][y1].isVide() && !Plateau[x1][y1].isRole(Role.BUT)) {
		// System.out.println("Je suis pas but");
		if (c2 != null && c2.isInsideTable(taille) && Plateau[x2][y2].isVide()) {
		    // System.out.println("Je suis vide");
		    if (Plateau[x1][y1].getRolePion() == Role.SINGE) {
			System.out.println("Deplacement Singe");
			return deplacerSinge(c1, c2);

		    }
		    if (Plateau[x1][y1].getRolePion() == Role.LION) {
			System.out.println("Deplacement Lion");
			return deplacerLion(c1, c2);
		    }
		    if (Plateau[x1][y1].getRolePion() == Role.DRAGON) {
			System.out.println("Deplacement dragon");
			return deplacerDragon(c1, c2);
		    }
		}
	    }
	}
	return false;
    }

    private boolean deplacerDragon(Case c1, Case c2) {
	int x1 = c1.getX();
	int y1 = c1.getY();
	int x2 = c2.getX();
	int y2 = c2.getY();

	boolean value = getPion(x1, y1).isAccesibleFrom(c1, c2);

	if (value) {
	    Case interm = getIntermCase(c1, c2);

	    if (interm != null) {
		Pion p = getPion(interm.getX(), interm.getY());
		if (p != null) {
		    if (p.getRole() == Role.BUT) {
			Plateau[x2][y2].setPion(Plateau[x1][y1].getPion());
			Plateau[x1][y1].setPion(null);
			return true;
		    } else {

			if (p.getCouleur() == getPion(x1, y1).getCouleur()) {
			    Plateau[x2][y2].setPion(Plateau[x1][y1].getPion());
			    Plateau[x1][y1].setPion(null);
			    return true;
			} else {
			    Plateau[x2][y2].setPion(Plateau[x1][y1].getPion());
			    Plateau[x1][y1].setPion(null);
			    Plateau[interm.getX()][interm.getY()].setPion(null);
			    SShang = true;
			    return true;
			}
		    }

		}
		return false;
	    }
	    return false;
	}
	return false;
    }

    private boolean deplacerLion(Case c1, Case c2) {

	// Faire test de 2 si interm ok sinon non. Test de 1 alors ok.

	int x1 = c1.getX();
	int y1 = c1.getY();
	int x2 = c2.getX();
	int y2 = c2.getY();

	boolean value = getPion(x1, y1).isAccesibleFrom(c1, c2);

	if (value) {
	    if (Plateau[x2][y2].getRolePion() == Role.BUT) {
		return false;
	    }
	    Case interm = getIntermCase(c1, c2);
	    if (interm != null) {
		Pion p = getPion(interm.getX(), interm.getY());

		if (p != null) {
		    if (p.getRole() == Role.SINGE || p.getRole() == Role.LION) {
			if (p.getCouleur() == getPion(x1, y1).getCouleur()) {
			    Plateau[x2][y2].setPion(Plateau[x1][y1].getPion());
			    Plateau[x1][y1].setPion(null);
			    return true;
			} else {
			    Plateau[x2][y2].setPion(Plateau[x1][y1].getPion());
			    Plateau[x1][y1].setPion(null);
			    Plateau[interm.getX()][interm.getY()].setPion(null);
			    SShang = true;
			    return true;
			}
		    }
		    return false;
		}
		return false;
	    } else {
		Plateau[x2][y2].setPion(Plateau[x1][y1].getPion());
		Plateau[x1][y1].setPion(null);
		return true;
	    }

	}
	return false;
    }

    private boolean deplacerSinge(Case c1, Case c2) {
	int x1 = c1.getX();
	int y1 = c1.getY();
	int x2 = c2.getX();
	int y2 = c2.getY();

	boolean value = getPion(x1, y1).isAccesibleFrom(c1, c2);

	if (value) {
	    if (Plateau[x2][y2].getRolePion() == Role.BUT) {
		return false;
	    }
	    Case interm = getIntermCase(c1, c2);

	    if (interm != null) {
		Pion p = getPion(interm.getX(), interm.getY());
		if (p != null) {
		    if (p.getRole() == Role.SINGE) {
			if (p.getCouleur() == getPion(x1, y1).getCouleur()) {
			    Plateau[x2][y2].setPion(Plateau[x1][y1].getPion());
			    Plateau[x1][y1].setPion(null);
			    return true;

			} else {
			    Plateau[x2][y2].setPion(Plateau[x1][y1].getPion());
			    Plateau[x1][y1].setPion(null);
			    Plateau[interm.getX()][interm.getY()].setPion(null);
			    SShang = true;
			    return true;
			}
		    }
		    return false;
		}
		Plateau[x2][y2].setPion(Plateau[x1][y1].getPion());
		Plateau[x1][y1].setPion(null);
		return true;
	    }
	    Plateau[x2][y2].setPion(Plateau[x1][y1].getPion());
	    Plateau[x1][y1].setPion(null);
	    return true;
	} else {
	    return false;
	}
    }

    public Couleur getCouleur(Case c1) {
	return Plateau[c1.getX()][c1.getY()].getCouleurPion();
    }

    public Case getIntermCase(Case c1, Case c2) {
	int x1 = c1.getX();
	int y1 = c1.getY();
	int x2 = c2.getX();
	int y2 = c2.getY();

	if (x2 == x1 + 2 && y2 == y1) {
	    return new Case(x1 + 1, y1);
	}
	if (x2 == x1 + 2 && y2 == y1 - 2) {
	    return new Case(x1 + 1, y1 - 1);
	}
	if (x2 == x1 && y2 == y1 - 2) {
	    return new Case(x1, y1 - 1);
	}
	if (x2 == x1 - 2 && y2 == y1 - 2) {
	    return new Case(x1 - 1, y1 - 1);
	}
	if (x2 == x1 - 2 && y2 == y1) {
	    return new Case(x1 - 1, y1);
	}
	if (x2 == x1 - 2 && y2 == y1 + 2) {
	    return new Case(x1 - 1, y1 + 1);
	}
	if (x2 == x1 && y2 == y1 + 2) {
	    return new Case(x1, y1 + 1);
	}
	if (x2 == x1 + 2 && y2 == y1 + 2) {
	    return new Case(x1 + 1, y1 + 1);
	}
	return null;
    }

    public boolean estGagner(Joueur j) {
	// CAS : Dragon sur but
	if (Plateau[8][5].getRolePion() == Role.DRAGON) {
	    Gagnant = Plateau[8][5].getCouleurPion();
	    return true;
	}

	if (Plateau[8][4].getRolePion() == Role.DRAGON) {
	    Gagnant = Plateau[8][4].getCouleurPion();
	    return true;
	}
	if (Plateau[1][5].getRolePion() == Role.DRAGON) {
	    Gagnant = Plateau[1][5].getCouleurPion();
	    return true;
	}
	if (Plateau[1][4].getRolePion() == Role.DRAGON) {
	    Gagnant = Plateau[1][4].getCouleurPion();
	    return true;
	}

	if (!isStillPion()) {
	    return true;
	}
	return false;
    }

    private boolean isStillPion() {
	int compteurJ1 = 0;
	int compteurJ2 = 0;

	for (int i = 0; i < taille; i++) {
	    for (int j = 0; j < taille; j++) {
		if (Plateau[i][j].getRolePion() != Role.BUT) {
		    if (Plateau[i][j].getCouleurPion() == Plateau[1][4].getCouleurPion())
			compteurJ1++;
		    if (Plateau[i][j].getCouleurPion() == Plateau[8][5].getCouleurPion())
			compteurJ2++;
		}
	    }
	}

	if (compteurJ1 == 0) {
	    Gagnant = Plateau[8][5].getCouleurPion();
	    return false;
	}
	if (compteurJ2 == 0) {
	    Gagnant = Plateau[1][4].getCouleurPion();
	    return false;
	}
	return true;
    }

    public Couleur getCouleurGagner() {
	if (Gagnant != Couleur.VIDE) {
	    return Gagnant;
	}

	return Couleur.VIDE;

    }

    public boolean isShingShang() {
	// TODO Auto-generated method stub
	return SShang;
    }

}
