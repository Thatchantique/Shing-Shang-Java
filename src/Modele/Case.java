package Modele;

/**
 * 
 * @author Guillaume GAUJAC
 * @version 1.0
 *
 */
public class Case {
    private int x, y;
    private Pion pion;
    private boolean actif = true;

    public Case() {
	pion = null;

    }

    /**
     * Constructeur de l'objet Case.
     * 
     * @param ligne
     *            Initialisation de la variable x (la ligne de notre case) avec
     *            la variable "ligne" passée en paramètre.
     * 
     * @param col
     *            Initialisation de la variable y (la collone de notre case)
     *            avec la variable "col" passée en paramètre.
     */
    public Case(int ligne, int col) {
	x = ligne;
	y = col;
	pion = null;
    }

    /**
     * 
     * @return La variable "actif" pour savoir si la case est accesible.
     */
    public boolean isEnable() {
	return actif;
    }

    /**
     * Regarde si la case contient un pion
     * 
     * @return true : S'il y a un pion sur la case. false : S'il n'y a pas de
     *         pion sur la case.
     */
    public boolean isVide() {
	if (pion == null) {
	    return true;
	}
	return false;
    }

    /**
     * isRole permet de tester un role passé en parametre. On regarde si ce rôle
     * est celui du pion placé sur notre case.
     * 
     * @param r
     *            Le role qu'on souhaite tester.
     * @return true : Le rôle passé en paramètre est le même que celui du pion.
     *         false : Il n'y a pas de pion ou le rôle est différent.
     */
    public boolean isRole(Role r) {
	if (pion != null) {
	    return pion.isRole(r);
	}
	return false;
    }

    /**
     * setDisable rend la case inactive.
     */
    public void setDisable() {
	actif = false;
    }

    /**
     * getPion sert à retourner le pion présent sur notre case.
     * 
     * @return Le pion présent sur la case.
     */
    public Pion getPion() {
	return pion;
    }

    /**
     * getRolePion permet de retourner le rôle du pion présent sur notre case.
     * 
     * @return Le rôle du pion situé sur la case (VIDE s'il n'y a pas de pion).
     */
    public Role getRolePion() {
	if (pion != null)
	    return pion.getRole();
	return Role.VIDE;
    }

    /**
     * getCouleurPion permet de retourner la couleur du pion présent sur notre
     * case.
     * 
     * @return La couleur du pion situé sur la case (VIDE s'il n'y a pas de
     *         pion).
     */
    public Couleur getCouleurPion() {
	if (pion != null)
	    return pion.getCouleur();
	return Couleur.VIDE;
    }

    /**
     * setPion nous permet d'assigner un pion sur notre case.
     * 
     * @param p
     *            Le pion que l'on souhaite placer sur la case.
     */
    public void setPion(Pion p) {
	pion = p;
    }

    /**
     * setPosition(int x, int y) nous permet d'assigner des coordonnées à la
     * case.
     * 
     * @param x
     *            La ligne où l'on souhaite positionner sa case.
     * @param y
     *            La colonne où l'on souhaite positionner sa case.
     */
    public void setPosition(int x, int y) {
	this.x = x;
	this.y = y;
    }

    /**
     * getX() sert à retourner la ligne (le x) de notre case.
     * 
     * @return La ligne de notre case.
     */
    public int getX() {
	return x;
    }

    /**
     * getY() sert à retourner la colonne (le y) de notre case.
     * 
     * @return La colonne de notre case.
     */
    public int getY() {
	return y;
    }

    /**
     * isInsideTable(int taille) nous permet de savoir si notre case appartient
     * à notre échiquier.
     * 
     * @param taille
     *            La taille de notre échiquier.
     * @return Toujours vrai sauf pour les cases inaccessibles, si on a une
     *         taille plus petite que notre échiquier et si nos coordonnées sont
     *         dans les négatifs.
     */
    public boolean isInsideTable(int taille) {
	if (((x >= 0 && x < 4) || (x >= 6 && x < 10)) && (y == 0 || y == 9))
	    return false;
	// false car ce sont les coordonées des cases inaccessibles
	if (taille < x || taille < y || x < 0 || y < 0) {
	    return false;
	    // false car on ne peut pas avoir un tableau dans les negatifs.
	    // false car on

	}
	return true;
    }
}
