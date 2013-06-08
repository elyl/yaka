import java.util.Scanner;
import java.util.ArrayList;

public class JoueurHumain extends Joueur
{
    private Scanner	sc;

    JoueurHumain(int couleur)
    {
	super(couleur);
	this.sc = new Scanner(System.in);
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

	liste = getCoups();	
	coup = null;
	tmp = "";
	while (coup == null)
	    {
		while (tmp.length() < 7)
		    tmp = sc.nextLine();
		x = Integer.parseInt(tmp.substring(0, 1));
		y = Integer.parseInt(tmp.substring(2, 3));
		c = Integer.parseInt(tmp.substring(4, 5));
		a = Integer.parseInt(tmp.substring(6, 7));
		if (x < 7 && x > 0 && y < 7 && y > 0 && c > 0 && c < Mouvements.ALL_MOVES.length)
		    coup = new Coup(Plateau.plateau[x][y], new Mouvement(Mouvements.ALL_MOVES[c].getDeltaX(), Mouvements.ALL_MOVES[c].getDeltaY(), a));
		if (!liste.contains(coup))
		    coup = null;
	    }
	return coup;
    }
}