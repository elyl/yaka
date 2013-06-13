/** Gestion des pieces fictives. */
public class PieceVide extends Piece {
    /** Initialise une piece fictive. */
    public PieceVide(int x, int y, int couleur) {
    	super(x, y, couleur, null);
    }

    /** Retourne le code de la piece fictive courante. */
    public char getCode() {
    	return ('.');
    }
}