public class PieceVide extends Piece
{
    public PieceVide(int x, int y, int couleur)
    {
	super(x, y, couleur, null);
    }

    public char getCode()
    {
	return ('.');
    }
}