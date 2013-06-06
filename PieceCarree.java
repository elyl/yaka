/** Gestion des pieces carrees. */
public class PieceCarree extends Piece
{
    /** Initialise une piece carree. */
    public PieceCarree(int x, int y, int couleur)
    {
	super(x, y, couleur, Mouvements.SQUARE_MOVE);
    }

    /** Retourne le code de la piece carree courante. */
    public char getCode()
    {
	if (super.getCouleur() == Piece.BLANC)
	    return ('C');
	else
	    return ('c');
    }
}