public class Main
{
    public static void main(String args[])
    {
	Plateau	p;
	Joueur	j;
	Joueur  j2;
	Coup	c;
	int	i;

	p = new Plateau();
	p.initialize();
	i = 0;
	j = new IA(Piece.BLANC);
	j2 = new JoueurHumain(Piece.NOIR);
	System.out.println(p);
	c = j.coupChoisi();
	while (!c.wining() && j.getPieces().size() != 0 && j2.getPieces().size() != 0)
	    {
		if (i++ % 2 == 0)
		    c = j.coupChoisi();
		else
		    c = j2.coupChoisi();
		if (!c.wining())
		    c.doIt();
		System.out.println(p);
	    }
	if (i % 2 == 1)
	    System.out.println("Joueur 1 gagne");
	else
	    System.out.println("Joueur 2 gagne");
    }

}