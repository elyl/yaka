import java.util.Scanner;
import java.util.ArrayList;

public class JoueurHumain extends Joueur
{
    private Scanner	sc;

    JoueurHumain(int couleur)
    {
	super(couleur);
	this.sc = new Scanner(System.in);
    }
    
    public Coup coupChoisi()
    {
	ArrayList<Coup> liste;

	liste = getCoups();
	
	return (null);
    }
}