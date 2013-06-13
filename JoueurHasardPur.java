import java.util.ArrayList;

/** Gestion de l'IA du joueur adverse. */
public class JoueurHasardPur extends Joueur {
	
    /** Initialise un joueur IA simple */
    public JoueurHasardPur(int couleur) {
    	super(couleur);
    }

    /** Effectue un coup au hasard. */
    public Coup coupChoisi() {
		ArrayList<Coup>	liste;
	
		liste = getCoups();
		return liste.get((int)(Math.random() * liste.size()));
    }
}