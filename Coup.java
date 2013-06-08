/** Gestion des coups. */
public class Coup
{
    private Piece	piece;
    private Mouvement	mouvement;
    private int		poids;

    public Coup(Piece piece, Mouvement mouvement)
    {
	this.piece = piece;
	this.mouvement = mouvement;
	this.poids = 0;
    }
    
    /** Retourne true si le coup est gagnant */
    public boolean wining()
    {
	return piece.winingMove(piece.getX() + piece.getCouleur() * mouvement.getDeltaX() * mouvement.getAmplitude());
    }

    /** Retourne true si le coup courant permet de capturer une piece adverse */
    public boolean capture()
    {
	return piece.capture(piece.getX() + piece.getCouleur() * mouvement.getDeltaX(), piece.getY() + mouvement.getDeltaY());
    }

    /** Realise le coup courant */
    public void doIt()
    {
	this.piece.move(this.mouvement);
    }

    /** Retourne le poids Attribué au coup courant */
    public int getPoids()
    {
	return poids;
    }
    
    /** Change le poids du coup courant */
    public void setPoids(int poids)
    {
	this.poids = poids;
    }

    /** Retourne la piece associee au mouvement courant . */
    public Piece getPiece()
    {
	return piece;
    }	

    /** Retourne le mouvement associé au mouvement courant. */
    public Mouvement getMouvement()
    {
	return mouvement;
    }

    /** Affiche les caracteristiques du coup courant */
    public String toString()
    {
	return ("Piece: " + this.piece + "; Mouvement : " + this.mouvement);
    }
}