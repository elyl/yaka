/** Classe abstraite pour la gestion des pieces. */
public abstract class Piece
{
    public static final int NOIR = -1;
    public static final int BLANC = 1;
    public static final int VIDE = 0;
    
    protected int		x;
    protected int		y;
    protected int		couleur;
    protected Mouvement		mouvements[];
    protected Joueur		joueur;

    /** Initialise une piece. */
    public Piece(int x, int y, int couleur, Mouvement mouvements[])
    {
	this.x = x;
	this.y = y;
	this.couleur = couleur;
	this.mouvements = mouvements;
	this.joueur = null;
    }

    /** Retourne l'abscisse de la piece courante. */
    public int getX()
    {
	return (this.x);
    }

    /** Retourne l'ordonnee de la piece courante. */
    public int getY()
    {
	return (this.y);
    }

    /** Retourne la couleur de la piece courante. */
    public int getCouleur()
    {
	return (this.couleur);
    }

    /** Retourne le joueur auquel appartient la piece courante. */
    public Joueur getJoueur()
    {
	return (this.joueur);
    }

    public void setJoueur(Joeuur j)
    {
	this.joueur = j;
    }

    /** Affiche les caracteristiques d'une piece. */
    public String toString()
    {
	String	str;

	str = "[" + this.x + ", " + this.y + "] : ";
	if (this.couleur == Piece.BLANC)
	    str = str + "Blanc";
	else
	    str = str + "Noir";
	return (str);
    }

    public abstract char getCode();

    /** Retourne les mouvements possibles pour la piece courante. */
    public Mouvement[] getMouvements()
    {
	return (this.mouvements);
    }

    /** Retourne true si la piece courante sort des limites du plateau. */
    public boolean moveOut(Mouvement m)
    {
	return (this.moveOut(this.y + this.couleur * m.getDeltaY()));
    }

    /** Est tres moche. Trololo. */
    private boolean moveOut(int newY)
    {
	if (newY > 7 || newY < 0)
	    return true;
	else
	    return false;
    }

    /** Retourne true si le mouvement de la piece courante fait gagner la partie. */
    public boolean winingMove(Mouvement m)
    {
	return (this.winingMove(this.y + this.couleur * m.getDeltaY()));
    }

    private boolean winingMove(int newY)
    {
	if (newY < 0 || newY > 7)
	    return true;
	else
	    return false;
    }

    /** Retourne true si le mouvement de la piece courante conduit à une colision. */
    public boolean colision(Mouvement m)
    {
	return (this.colision(this.x + this.couleur * m.getDeltaX(), this.y + this.couleur * m.getDeltaY()));
    }

    private boolean colision(int newX, int newY)
    {
	if (this.couleur == Plateau.plateau[newX][newY].getCouleur())
	    return true;
	else
	    return false;
    }

    /** Retourne true sir le mouvement de la piece courante est possible. */
    public boolean canMove(int newX, int newY)
    {
	if (!moveOut(newX) && (winingMove(newY) || !colision(newX, newY)))
	    return true;
	else
	    return false;
    }

    public boolean canMove(Mouvement m)
    {
	if (!moveOut(m) && (winingMove(m) || !colision(m)))
	    return true;
	else
	    return false;
    }

    /** Deplace la piece courante. */
    public void move(Mouvement m)
    {
	int	newX;
	int	newY;

	newX = this.x + this.couleur * m.getDeltaX();
	newY = this.y + this.couleur * m.getDeltaY();
	Plateau.plateau[this.x][this.y] = new PieceVide(this.x, this.y, Piece.VIDE);
	if (Plateau.plateau[newX][newY].getJoueur() != null)
	    Plateau.plateau[newX][newY].getJoueur().removePiece(Plateau.plateau[newX][newY]);
	Plateau.plateau[newX][newY] = this;
	this.x = newX;
	this.y = newY;
    }
}