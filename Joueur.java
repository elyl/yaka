import java.util.ArrayList;

public abstract class Joueur
{
    private ArrayList<Piece>	pieces;
    private int			couleur;
    
    public Joueur(int couleur)
    {
	this.couleur = couleur;
	this.pieces = new ArrayList<Piece>(16);
    }

    public ArrayList<Coup> getCoups()
    {
	ArrayList<Coup> coups;

	coups = new ArrayList<Coup>;
	return (coups);
    }

    public abstract Coup coupChoisi();
}