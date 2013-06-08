/** Gestion des coups. */
public class Coup
{
    Piece	piece;
    Mouvement	mouvement;

    public Coup(Piece piece, Mouvement mouvement)
    {
	this.piece = piece;
	this.mouvement = mouvement;
    }
    
    /** Retourne true si le coup est gagnant */
    public boolean wining()
    {
	return piece.winingMove(piece.getX() + piece.getCouleur() * mouvement.getDeltaX() * mouvement.getAmplitude());
    }

    /** Retourne true si le coup courant permet de capturer une piece adverse */
    public boolean capture()
    {
	return (true);
    }

    /** Realise le coup courant */
    public void doIt()
    {
	this.piece.move(this.mouvement);
    }

    /** Affiche les caracteristiques du coup courant */
    public String toString()
    {
	return ("Piece: " + this.piece + "; Mouvement : " + this.mouvement);
    }
}