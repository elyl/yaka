import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class PieceComposee extends Piece
{
    public PieceComposee(int x, int y, Piece p1, Piece p2)
    {
	super(x, y, p1.getCouleur(), null);
	super.joueur = p1.getJoueur();
	super.mouvements = this.genMouvements(p1.getMouvements(), p2.getMouvements());
    }

    private Mouvement[] genMouvements(Mouvement m1[], Mouvement m2[])
    {
       	ArrayList<Mouvement>	mouvements;
	Iterator<Mouvement>	itr;
	Mouvement		elem;

	mouvements = new ArrayList<Mouvement>();
	mouvements.addAll(Arrays.asList(m1));
	itr = Arrays.asList(m2).iterator();
	while (itr.hasNext())
	    {
		elem = itr.next();
		if (mouvements.contains(elem))
		    elem.setAmplitude(elem.getAmplitude() + 1);
		mouvements.add(elem);
	    }
	return (mouvements.toArray());
    }

    public char getCode()
    {
	return ('x');
    }
}