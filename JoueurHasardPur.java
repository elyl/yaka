import java.util.ArrayList;

/** Gestion de l'IA du joueur adverse. */
public class JoueurHasardPur extends Joueur
{
    public JoueurHasardPur(int couleur)
    {
	super(couleur);
    }

    /** Effectue un coup au hasard. */
    public Coup coupChoisi()
    {
	ArrayList<Coup>	liste;

	liste = this.getCoups();
	return (liste.get((int)(Math.random() * liste.size())));
    }
}