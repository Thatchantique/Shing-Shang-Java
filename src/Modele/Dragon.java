package Modele;

/**
 * Dragon est une classe qui hérite de Pion. Cette classe nous sert à définir
 * 
 * @author Guillaume GAUJAC
 * @version 1.0
 *
 */
public class Dragon extends Pion {
    public Dragon(Couleur c) {
	role = Role.DRAGON;
	couleur = c;
    }

    public Role getRole() {
	return role;
    }

    public boolean isAccesibleFrom(Case c1, Case c2) {

	// pareille que Singe et Lion sauf qu'on garde que l'écart de 2

	int x1 = c1.getX();
	int x2 = c2.getX();
	int y1 = c1.getY();
	int y2 = c2.getY();

	if (x2 == x1 && (y2 == y1 + 2 || y2 == y1 - 2)) {
	    return true;
	}
	if ((x2 == x1 + 2 || x2 == x1 - 2) && (y2 == y1)) {
	    return true;
	}
	if ((x2 == x1 + 2 || x2 == x1 - 2) && (y2 == y1 + 2 || y2 == y1 - 2)) {
	    return true;
	}

	return false;
    }
}
