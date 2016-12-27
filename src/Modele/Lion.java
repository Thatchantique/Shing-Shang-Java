package Modele;

/**
 * 
 * @author Guillaume GAUJAC
 * @version 1.0
 */
public class Lion extends Pion {
    /**
     * Constructeur de l'objet Lion.
     * 
     * @param c
     *            Un lion se différencie grâce à sa couleur.
     */
    public Lion(Couleur c) {
	role = Role.LION;
	couleur = c;
    }

    public Role getRole() {
	return role;
    }

    public boolean isAccesibleFrom(Case c1, Case c2) {
	// Pareille que le singe sauf que 2 pour saut
	int x1 = c1.getX();
	int x2 = c2.getX();
	int y1 = c1.getY();
	int y2 = c2.getY();

	if (x2 == x1 && y2 <= y1 + 2 && y2 >= y1 - 2 && y2 != y1) {
	    return true;
	}
	if (y2 == y1 && x2 <= x1 + 2 && x2 >= x1 - 2 && x2 != x1) {
	    return true;
	}
	if ((x2 == x1 + 1 || x2 == x1 - 1) && (y2 == y1 + 1 || y2 == y1 - 1)) {
	    return true;
	}
	if ((y2 == y1 + 2 || y2 == y1 - 2) && (x2 == x1 + 2 || x2 == x1 - 2)) {
	    return true;
	}

	return false;
    }

}