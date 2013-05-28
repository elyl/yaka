import java.util.ArrayList;

public abstract class Joueur
{
    protected ArrayList<Piece>	pieces;
    protected int		couleur;
    
    public Joueur(int couleur)
    {
	this.couleur = couleur;
	this.pieces = new ArrayList<Piece>(16);
    }

    public ArrayList<Coup> getCoups()
    {
	ArrayList<Coup> coups;

	coups = new ArrayList<Coup>();
	return (coups);
    }

    public abstract Coup coupChoisi();
}