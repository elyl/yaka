public class PieceRonde extends Piece
{
    public PieceRonde(int x, int y, int couleur)
    {
	super(x, y, couleur);
    }

    public char getCode()
    {
	if (super.getCouleur() == Piece.BLANC)
	    return ('R');
	else
	    return ('r');
    }
}