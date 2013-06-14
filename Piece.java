/** Classe abstraite pour la gestion des pieces. */
public abstract class Piece {
    public static final int NOIR = -1;
    public static final int BLANC = 1;
    public static final int VIDE = 0;
    
    protected int		x;
    protected int		y;
    protected int		couleur;
    protected Mouvement		mouvements[];
    protected Joueur		joueur;

    /** Initialise une piece. */
    public Piece(int x, int y, int couleur, Mouvement mouvements[]) {	
		this.x = x;
		this.y = y;
		this.couleur = couleur;
		this.mouvements = mouvements;
		this.joueur = null;
    }

    /** Retourne l'abscisse de la piece courante. */
    public int getX() {
    	return (this.x);
    }

    /** Retourne l'ordonnee de la piece courante. */
    public int getY() {
    	return (this.y);
    }

    /** Retourne la couleur de la piece courante. */
    public int getCouleur() {
    	return (this.couleur);
    }

    /** Retourne le joueur auquel appartient la piece courante. */
    public Joueur getJoueur() {
    	return (this.joueur);
    }

    public void setJoueur(Joueur j) {
    	this.joueur = j;
    }

    /** Retourne true si la piece courante est empilable. */
    public boolean canStack() {
    	return true;
    }

    /** Affiche les caracteristiques d'une piece. */
    public String toString() {
		String	str;
	
		str = "[" + this.x + ", " + this.y + "] : ";
		if (this.couleur == Piece.BLANC)
		    str = str + "Blanc";
		else
		    str = str + "Noir";
		return (str);
    }

    public abstract String getCode();

    /** Retourne les mouvements possibles pour la piece courante. */
    public Mouvement[] getMouvements() {
    	return (this.mouvements);
    }

    /** Retourne true si la piece courante sort des limites du plateau. */
    private boolean moveOut(int newY) {
    	return newY > 7 || newY < 0;
    }

    /** Retourne true si le mouvement de la piece courante fait gagner la partie. */
    public boolean winingMove(int newX) {
    	return newX < 0 || newX > 7;
    }
    
    /** Retourne la distance qui separe la piece de la victoire. */
    public int distanceToWin() {
    	return (couleur == Piece.BLANC) ? 7 - x : x;
    }

    /** Retourne le nombre de pieces empilees. */
    public int getSize() {
    	return 1;
    }

    /** Retourne true si le mouvement de la piece courante conduit à une colision. */
    public boolean colision(int newX, int newY) {
    	return this.couleur == Plateau.plateau[newX][newY].getCouleur() && !this.canStack() && !Plateau.plateau[newX][newY].canStack();
    }

    /** Retourne true si le mouvement permet de capturer une piece adversaire */
    public boolean capture(int newX, int newY) {
    	return Plateau.plateau[newX][newY].getCouleur() == couleur * -1;
    }

    /** Retourne true sir le mouvement de la piece courante est possible. */
    public boolean canMove(Mouvement m) {
		int	newX;
		int	newY;
	
		newX = this.x + this.couleur * m.getDeltaX() * m.getAmplitude();
		newY = this.y + m.getDeltaY() * m.getAmplitude();
		return !moveOut(newY) && (winingMove(newX) || !colision(newX, newY));
    }

    /** Deplace la piece courante. */
    public void move(Mouvement m) {
		int	newX;
		int	newY;
		Joueur	j;
	
		newX = this.x + this.couleur * m.getDeltaX() * m.getAmplitude();
		newY = this.y + m.getDeltaY() * m.getAmplitude();
		Plateau.plateau[this.x][this.y] = new PieceVide(this.x, this.y, Piece.VIDE);
		j = Plateau.plateau[newX][newY].getJoueur();
	        if (j != null)
		   Plateau.plateau[newX][newY].getJoueur().removePiece(Plateau.plateau[newX][newY]);
		if (j == joueur)
		    Plateau.plateau[newX][newY] = new PieceComposee(newX, newY, this, Plateau.plateau[newX][newY]);
		else
		    Plateau.plateau[newX][newY] = this;
		this.x = newX;
		this.y = newY;
    }
}