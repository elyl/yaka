import java.util.ArrayList;

public class JoueurHasardPur extends Joueur
{
    public JoueurHasardPur(int couleur)
    {
	super(couleur);
    }

    public Coup coupChoisi()
    {
	ArrayList<Coup>	liste;

	liste = this.getCoups();
	return (liste.get((int)(Math.random() * liste.size())));
    }
}