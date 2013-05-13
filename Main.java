import java.util.ArrayList;
import java.util.Iterator;

public class Main
{
    public static void main(String args[])
    {
	Plateau	p;
	Joueur	j;

	p = new Plateau();
	p.initialize();
	j = new JoueurHasardPur(Piece.BLANC);
	System.out.println(j);
	printList(j.getCoups());
	System.out.println(p);
	System.out.println(Plateau.plateau[1][3].canMove(Mouvements.AHEAD));
    }

    public static <E> void printList(ArrayList<E> l)
    {
	Iterator<E>	itr;

	itr = l.iterator();
	while (itr.hasNext())
	    System.out.println(itr.next());
    }
}