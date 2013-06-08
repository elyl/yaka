import java.util.ArrayList;

/** Gestion de l'IA du joueur adverse. */
public class JoueurHasardPur extends Joueur
{
    /** Effectue un coup au hasard. */
    public Coup coupChoisi()
    {
	ArrayList<Coup>	liste;

	liste = this.getCoups();
	return (liste.get((int)(Math.random() * liste.size())));
    }
}