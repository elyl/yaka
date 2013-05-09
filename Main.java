public class Main
{
    public static void main(String args[])
    {
	Plateau	p;

	p = new Plateau();
	p.initialize();
	System.out.println(p);
	System.out.println(Plateau.plateau[1][3].canMove(Mouvements.AHEAD));
    }
}