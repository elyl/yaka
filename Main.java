import java.util.Iterator;
import java.util.List;

public class Main
{
    public static void main(String args[])
    {
	Plateau	p;
	Joueur	j;
	Joueur  j2;

	p = new Plateau();
	p.initialize();
	j = new JoueurHasardPur(Piece.BLANC);
	System.out.println("toto");
	j2 = new JoueurHumain(Piece.NOIR);
	System.out.println(j);
	printList(j.getCoups());
	j.coupChoisi().doIt();
	System.out.println(p);
	j2.coupChoisi().doIt();
	System.out.println(p);
	System.out.println(Plateau.plateau[1][3].canMove(Mouvements.AHEAD));
    }

    public static <E> void printList(List<E> l)
    {
	Iterator<E>	itr;

	itr = l.iterator();
	while (itr.hasNext())
	    System.out.println(itr.next());
    }
}