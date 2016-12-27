package Modele;

public class Portail extends Pion {

    /**
     * 
     * @param c
     *            La couleur que l'on souhaite attribuer au portail.
     */

    public Portail(Couleur c) {
	role = Role.BUT;
	couleur = c;
    }

    public Role getRole() {
	return role;
    }
}
