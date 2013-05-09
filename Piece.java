public abstract class Piece
{
    public static final int NOIR = 1;
    public static final int BLANC = -1;
    public static final int VIDE = 0;
    
    private int	x;
    private int	y;
    private int	couleur;
    
    public Piece(int x, int y, int couleur)
    {
	this.x = x;
	this.y = y;
	this.couleur = couleur;
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

    public boolean moveOut(Mouvement m)
    {
	int	newX;

	newX = this.x + this.couleur * m.getDeltaX();
	if (newX > 7 || newX < 0)
	    return (true);
	else
	    return (false);
    }

    public boolean winingMove(Mouvement m)
    {
	int	newY;

	newY = this.y + this.couleur * m.getDeltaY();
	if (newY < 0 || newY > 7)
	    return (true);
	else
	    return (false);
    }

    public boolean colision(Mouvement m)
    {
	int	newX;
	int	newY;

	newX = this.x + this.couleur * m.getDeltaX();
	newY = this.y + this.couleur * m.getDeltaY();
	if (this.couleur == Plateau.plateau[newX][newY].getCouleur())
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
}