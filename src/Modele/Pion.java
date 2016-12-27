package Modele;

/**
 * 
 * @author Guillaume GAUJAC
 * @version 1.0
 */
public class Pion {

    protected Couleur couleur;
    protected Role role;

    /**
     * Le constructeur de notre objet Pion.
     */
    public Pion() {
	role = Role.VIDE;
	couleur = Couleur.VIDE;

    }

    /**
     * IsAccesibleFrom nous sert à savoir qu'elles sont les cases accessibles à
     * partir de notre pion.
     * 
     * @param c1 Une case initiale.
     * @param c2 Une case finale.
     * @return True : la case est accessible pour notre pion. False : elle ne l'est pas.
     */
    public boolean isAccesibleFrom(Case c1, Case c2) {
	// Un pion standard ne peut pas être accessible. De ce fait nous
	// renvoyons forcément false.

	return false;
    }

    /**
     * getCouleur nous sert à retourner la couleur de notre pion.
     * 
     * @return La couleur du Pion
     */
    public Couleur getCouleur() {
	return couleur;
    }

    /**
     * getRole nous sert à retourner le rôle de notre pion.
     * 
     * @return Le role du pion.
     */
    public Role getRole() {
	return role;
    }

    /**
     * IsRole nous permet de savoir si le rôle mis en paramètre est le même que
     * celui de notre pion.
     * 
     * @param r
     *            Un role à tester.
     * @return Un boolean permettant de savoir si le rôle testé est le même que
     *         celui de notre pion.
     */
    public boolean isRole(Role r) {
	if (r != role) {
	    return false;
	}
	return true;

    }
}
