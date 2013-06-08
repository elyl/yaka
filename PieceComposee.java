import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class PieceComposee extends Piece
{
    public PieceComposee(int x, int y, Piece p1, Piece p2)
    {
	super(x, y, p1.getCouleur(), null);
	super.joueur = p1.getJoueur();
	this.genMouvements(p1.getMouvements(), p2.getMouvements());
    }

    private void genMouvements(Mouvement m1[], Mouvement m2[])
    {
       	ArrayList<Mouvement>	mouvements;
	Iterator<Mouvement>	itr;
	Mouvement		elem;
	int			i;

	mouvements = new ArrayList<Mouvement>();
	mouvements.addAll(Arrays.asList(m1));
	itr = Arrays.asList(m2).iterator();
	while (itr.hasNext())
	    {
		elem = itr.next();
		if (mouvements.contains(elem))
		    elem = new Mouvement(elem.getDeltaX(), elem.getDeltaY(), elem.getAmplitude() + 1);
		mouvements.add(elem);
	    }
	super.mouvements = new Mouvement[mouvements.size()];
	itr = mouvements.iterator();
	i = 0;
	while (itr.hasNext())
	    super.mouvements[i++] = itr.next();
    }

    public char getCode()
    {
	return ('x');
    }
}