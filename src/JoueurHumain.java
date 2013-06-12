import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class JoueurHumain extends Joueur
{
    private Scanner	sc;

    JoueurHumain(int couleur)
    {
	super(couleur);
    }
    
    public Coup coupChoisi()
    {
	String		tmp;
	ArrayList<Coup> liste;
	Coup		coup;
	int		x;
	int		y;
	int		c;
	int		a;

	if (sc == null)
	    sc = new Scanner(System.in);
	liste = getCoups();	
	coup = null;
	while (coup == null)
	    {
		tmp = "";
		while (tmp.length() < 7)
		    tmp = sc.nextLine();
		x = Integer.parseInt(tmp.substring(0, 1));
		y = Integer.parseInt(tmp.substring(2, 3));
		c = Integer.parseInt(tmp.substring(4, 5));
		a = Integer.parseInt(tmp.substring(6, 7));
		if (x < 8 && x >= 0 && y < 8 && y >= 0 && c >= 0 && c < Mouvements.ALL_MOVES.length)
		    coup = new Coup(Plateau.plateau[x][y], new Mouvement(Mouvements.ALL_MOVES[c].getDeltaX(), Mouvements.ALL_MOVES[c].getDeltaY(), a));
		if (coup != null && !inList(liste, coup))
		    {
			System.out.println("Coup pas dans la liste");
			coup = null;
		    }
	    }
	return coup;
    }

    private boolean inList(ArrayList<Coup> coups, Coup c)
    {
	Iterator<Coup>	itr;
	Coup		elem;

	itr = coups.iterator();
	while (itr.hasNext())
	    {
		elem = itr.next();
		if (elem.getPiece() == c.getPiece() && elem.getMouvement().equals(c.getMouvement()) && elem.getMouvement().getAmplitude() == c.getMouvement().getAmplitude())
		    return true;
	    }
	return false;
    }
}