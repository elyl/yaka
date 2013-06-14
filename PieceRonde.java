/** Gestion des pieces rondes. */
public class PieceRonde extends Piece
{
    /** Initialise une piece ronde. */
    public PieceRonde(int x, int y, int couleur) {
    	super(x, y, couleur, Mouvements.ROUND_MOVE);
    }

    /** Retourne le code de la piece ronde courante. */
    public String getCode() {
		if (super.getCouleur() == Piece.BLANC)
		    return (" R ");
		else
		    return (" r ");
	}
}