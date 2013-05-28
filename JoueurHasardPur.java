public class JoueurHasardPur extends Joueur
{
    public JoueurHasardPur(int couleur)
    {
	super(couleur);
    }

    public Coup coupChoisi()
    {
	return (this.getCoups().get(1));
    }
}