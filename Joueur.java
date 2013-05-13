import java.util.ArrayList;
import java.util.Iterator;
import java.util.Arrays;

public abstract class Joueur
{
    protected ArrayList<Piece>	pieces;
    protected int		couleur;
    
    public Joueur(int couleur)
    {
	this.couleur = couleur;
	this.pieces = new ArrayList<Piece>(16);
	this.getPieces();
    }

    private void getPieces()
    {
	int	i;
	int	j;

	i = (this.couleur == Piece.BLANC) ? 0 : 6;
	while (i < 2 || (i < 8 && i > 2)) //A revoir, moche
	    {
		j = 0;
		while (j < 8)
		    this.pieces.add(Plateau.plateau[i][j++]);
		i++;
	    }
    }

    public ArrayList<Coup> getCoups()
    {
	ArrayList<Coup>		coups;
	Iterator<Piece>		itr;
	Iterator<Mouvement>	itr2;
	Piece			p;
	Mouvement		m;

	coups = new ArrayList<Coup>();
	itr = this.pieces.iterator();
	while (itr.hasNext())
	    {
		p = itr.next();
		itr2 = Arrays.asList(p.getMouvements()).iterator();
		while (itr2.hasNext())
		    {
			m = itr2.next();
			if (p.canMove(m))
			    coups.add(new Coup(p, m));
		    }
	    }
	return (coups);
    }

    public abstract Coup coupChoisi();

    public void removePiece(Piece p)
    {
	this.pieces.remove(p);
    }

    public String toString()
    {
	Iterator<Piece>	itr;
	String		str;

	str = "";
	itr = this.pieces.iterator();
	while (itr.hasNext())
	    str = str + itr.next().toString() + "\n";
	return (str);
    }
}