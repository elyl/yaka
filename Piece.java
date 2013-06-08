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

    public Piece(int x, int y, int couleur, Mouvement mouvements[])
    {
	this.x = x;
	this.y = y;
	this.couleur = couleur;
	this.mouvements = mouvements;
    }

    public int getX()
    {
	return (this.x);
    }

    public int getY()
    {
	return (this.y);
    }

    public int getCouleur()
    {
	return (this.couleur);
    }

    public Joueur getJoueur()
    {
	return (this.joueur);
    }

    public void setJoueur(Joueur j)
    {
	this.joueur = j;
    }

    public boolean canStack()
    {
	return true;
    }

    public String toString()
    {
	String	str;

	str = "[" + this.x + ", " + this.y + "]:";
	if (this.couleur == Piece.BLANC)
	    str = str + "Blanc";
	else
	    str = str + "noir";
	return (str);
    }

    public char getCode()
    {
	return ('.');
    }

    public Mouvement[] getMouvements()
    {
	return (this.mouvements);
    }

    public boolean moveOut(int newY)
    {
	return newY > 7 || newY < 0;
    }

    public boolean winingMove(int newX)
    {
	return newX < 0 || newX > 7;
    }

    public boolean colision(int newX, int newY)
    {
	return this.couleur == Plateau.plateau[newX][newY].getCouleur() && !this.canStack() && !Plateau.plateau[newX][newY].canStack();
    }

    public boolean canMove(Mouvement m)
    {
	int	newX;
	int	newY;

	newX = this.x + this.couleur * m.getDeltaX() * m.getAmplitude();
	newY = this.y + this.couleur * m.getDeltaY() * m.getAmplitude();
	return !moveOut(newY) && (winingMove(newX) || !colision(newX, newY));
    }

    public boolean move(Mouvement m)
    {
	int	newX;
	int	newY;
	Joueur	j;

	newX = this.x + this.couleur * m.getDeltaX() * m.getAmplitude();
	newY = this.y + this.couleur * m.getDeltaY() * m.getAmplitude();
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
	return (true);
    }
}