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

    public boolean moveOut(Mouvement m)
    {
	return (this.moveOut(this.x + this.couleur * m.getDeltaX()));
    }

    private boolean moveOut(int newX)
    {
	if (newX > 7 || newX < 0)
	    return (true);
	else
	    return (false);
    }

    public boolean winingMove(Mouvement m)
    {
	return (this.winingMove(this.y + this.couleur * m.getDeltaY()));
    }

    private boolean winingMove(int newY)
    {
	if (newY < 0 || newY > 7)
	    return (true);
	else
	    return (false);
    }

    public boolean colision(Mouvement m)
    {
	return (this.colision(this.x + this.couleur * m.getDeltaX(), this.y + this.couleur * m.getDeltaY()));
    }

    private boolean colision(int newX, int newY)
    {
	if (this.couleur == Plateau.plateau[newX][newY].getCouleur())
	    return (true);
	else
	    return (false);
    }

    public boolean canMove(int newX, int newY)
    {
	if (!moveOut(newX) && (winingMove(newY) || !colision(newX, newY)))
	    return (true);
	else
	    return (false);
    }

    public boolean canMove(Mouvement m)
    {
	if (!moveOut(m) && (winingMove(m) || !colision(m)))
	    return (true);
	else
	    return (false);
    }

    public boolean move(Mouvement m)
    {
	int	newX;
	int	newY;

	newX = this.x + this.couleur * m.getDeltaX();
	newY = this.y + this.couleur * m.getDeltaY();
	Plateau.plateau[this.x][this.y] = new PieceVide(this.x, this.y, Piece.VIDE);
	Plateau.plateau[newX][newY].getJoueur().removePiece(Plateau.plateau[newX][newY]);
	Plateau.plateau[newX][newY] = this;
	this.x = newX;
	this.y = newY;
	return (true);
    }
}