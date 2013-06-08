import java.util.ArrayList;
import java.util.Iterator;
import java.util.Arrays;
import java.util.List;

public class Main
{
    public static void main(String args[])
    {
	Plateau	p;
	Joueur	j;
	Piece	pc;

	p = new Plateau();
	p.initialize();
	j = new JoueurHasardPur(Piece.BLANC);
	System.out.println(j);
	printList(j.getCoups());
	j.coupChoisi().doIt();
	System.out.println(p);
	System.out.println(Plateau.plateau[1][3].canMove(Mouvements.AHEAD));
	//pc = new PieceComposee(4, 4, Plateau.plateau[1][2], Plateau.plateau[1][4]);
	//printList(Arrays.asList(pc.getMouvements()));
    }

    public static <E> void printList(List<E> l)
    {
	Iterator<E>	itr;

	itr = l.iterator();
	while (itr.hasNext())
	    System.out.println(itr.next());
    }
}