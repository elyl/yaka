import java.util.ArrayList;
import java.util.Iterator;

/** IA avancé */

public class IA extends Joueur
{
    public IA(int couleur)
    {
	super(couleur);
    }

    /** Choisi un coup a jouer parmis la liste des coups possibles */
    public Coup coupChoisi()
    {
	ArrayList<Coup> coups;
	Iterator<Coup>	itr;
	Coup		max;
	Coup		elem;

	coups = getCoups();
	calcPoids(coups);
	itr = coups.iterator();
	max = itr.next();
	while (itr.hasNext())
	    {
		elem = itr.next();
		max = (elem.getPoids() > max.getPoids()) ? elem : max;
	    }
	return max;
    }

	private void calcPoids(ArrayList<Coup> coups)
	    {
		Coup		elem;
		Iterator<Coup>	itr;

		itr = coups.iterator();
		while (itr.hasNext())
		    {
			elem = itr.next();
			if (elem.capture())
			    elem.setPoids(elem.getPoids() + 10);
			if (elem.wining())
			    elem.setPoids(100);
			elem.setPoids(elem.getPoids() + (8 - elem.getPiece().distanceToWin()));
		    }
	    }
}