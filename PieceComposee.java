import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/** Gestion des pices composees et de l'empilement */

public class PieceComposee extends Piece {
    private ArrayList<Piece> pieces;

    /** Initialise une piece composee. */
    public PieceComposee(int x, int y, Piece p1, Piece p2) {
		super(x, y, p1.getCouleur(), null);
		this.joueur = p1.getJoueur();
		this.pieces = new ArrayList<Piece>(3);
		if (!this.pieces.contains(p1))
		    this.pieces.add(p1);
		if (!this.pieces.contains(p2))
		    this.pieces.add(p2);
		this.genMouvements(p1.getMouvements(), p2.getMouvements());
		this.joueur.addPiece(this);
    }

    /** Genere la liste des mouvements possibles pour la piece en cours de creation. */
    private void genMouvements(Mouvement m1[], Mouvement m2[]) {
       	ArrayList<Mouvement>	mouvements;
		Iterator<Mouvement>	itr;
		Mouvement		elem;
		int			i;
		int			index;
	
		mouvements = new ArrayList<Mouvement>();
		mouvements.addAll(Arrays.asList(m1));
		itr = Arrays.asList(m2).iterator();
		while (itr.hasNext())
		    {
			elem = itr.next();
			if ((index = indexOf(mouvements, elem)) != -1)
			    elem = new Mouvement(elem.getDeltaX(), elem.getDeltaY(), elem.getAmplitude() + mouvements.get(index).getAmplitude());
			mouvements.add(elem);
		    }
		super.mouvements = new Mouvement[mouvements.size()];
		itr = mouvements.iterator();
		i = 0;
		while (itr.hasNext())
		    super.mouvements[i++] = itr.next();
    }

    /** Retourne l'index du mouvement m au sein de la liste de mouvements. */
    private int indexOf(ArrayList<Mouvement> mouvements, Mouvement m) {
		Iterator<Mouvement>	itr;
		int			i;
	
		i = 0;
		itr = mouvements.iterator();
		while (itr.hasNext())
		    {
			if (itr.next().equals(m))
			    return i;
			i++;
		    }
		return -1;
    }

    /** Retourne le nombre de pieces empilees. */
    public int getSize() {
    	return pieces.size();
    }

    /** Renvoie true si la piece est empilable (moins de trois pieces). */
    public boolean canStack(){
    	return (this.pieces.size() < 3);
    }

    /** Retourne le code de la piece composee courante. */
    public char getCode(){
    	return ('x');
    }
}