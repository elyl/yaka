public abstract class Piece
{
    public static final int NOIR = -1;
    public static final int BLANC = 1;
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
}