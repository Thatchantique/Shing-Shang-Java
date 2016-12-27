package Modele;

public class Singe extends Pion {

    public Singe(Couleur c) {
	role = Role.SINGE;
	couleur = c;
    }

    public boolean isAccesibleFrom(Case c1, Case c2) {

	// Meme chose que lion sauf que 2 pour saut et deplacement

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
