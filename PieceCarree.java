public class PieceCarree extends Piece
{
    public PieceCarree(int x, int y, int couleur)
    {
	super(x, y, couleur);
    }

    public char getCode()
    {
	if (super.getCouleur() == Piece.BLANC)
	    return ('C');
	else
	    return ('c');
    }
}