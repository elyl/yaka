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
	return (this.piece.winingMove(this.mouvement));
    }

    public boolean capture()
    {
	return (true);
    }

    public void doIt()
    {
	this.piece.move(this.mouvement);
    }
}