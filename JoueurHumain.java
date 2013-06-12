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
	int		codeMouvement;
	int		amplitude;

	if (sc == null)
	    sc = new Scanner(System.in);
	liste = getCoups();	
	coup = null;
	while (coup == null)
	    {
		tmp = "";
		while (tmp.length() < 7)
		    tmp = sc.nextLine();
		x = tmp.charAt(0) - '0';
		y = tmp.charAt(2) - '0';
		codeMouvement = tmp.charAt(4) - '0';
		amplitude = tmp.charAt(6) - '0';
		if (x < 8 && x >= 0 && y < 8 && y >= 0 && codeMouvement >= 0 && codeMouvement < Mouvements.ALL_MOVES.length)
		    coup = new Coup(Plateau.plateau[x][y], new Mouvement(Mouvements.ALL_MOVES[codeMouvement].getDeltaX(), Mouvements.ALL_MOVES[codeMouvement].getDeltaY(), amplitude));
		if (coup != null && !inList(liste, coup))
		    coup = null;
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