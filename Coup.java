public class Coup
{
    Piece	piece;
    Mouvement	mouvement;

    public Coup(Piece piece, Mouvement mouvement)
    {
	this.piece = piece;
	this.mouvement = mouvement;
    }

    public boolean wining()
    {
	return piece.winingMove(piece.getX() + piece.getCouleur() * mouvement.getDeltaX() * mouvement.getAmplitude());
    }

    public boolean capture()
    {
	return (true);
    }

    public void doIt()
    {
	this.piece.move(this.mouvement);
    }

    public String toString()
    {
	return ("Piece: " + this.piece + "; Mouvement : " + this.mouvement);
    }
}