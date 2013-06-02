import java.util.ArrayList;
import java.util.Arrays;

public class PieceComposee extends Piece
{
    private ArrayList<Piece>	pieces;

    public PieceComposee(int x, int y, Piece p1, Piece p2)
    {
	super(x, y, p1.getCouleur(), null);
	this.pieces = new ArrayList<Piece>(3);
	super.joueur = p1.getJoueur();
	super.mouvements = this.genMouvements(p1.getMouvements(), p2.getMouvements());
    }

    private Mouvement[] genMouvements(Mouvement[] m1, Mouvement[] m2)
    {
       	ArrayList<Mouvement>	mouvements;

	mouvements = new ArrayList<Mouvement>();
	mouvements.addAll(Arrays.asList(m1));
	return (null);
    }

    public char getCode()
    {
	return ('x');
    }
}