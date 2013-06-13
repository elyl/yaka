/** Gestion du plateau de jeu. */
public class Plateau
{
    public static Piece plateau[][];

    /** Genere un plateau de jeu vide. */
    public Plateau()
    {
	Plateau.plateau = new Piece[8][8];
    }

    /** Initialise le plateau de jeu courant. */
    public void initialize()
    {
	int n = 0;

	for(int j = 0; j < 8; j++){
	    for(int i = 0; i < 2; i++){
		if (n % 2 == 1)
		    Plateau.plateau[i][j] = new PieceCarree(i, j, Piece.BLANC);
		else
		    Plateau.plateau[i][j] = new PieceRonde(i, j, Piece.BLANC);
		n++;
	    }

	    for(int i = 2; i < 6; i++){
		Plateau.plateau[i][j] = new PieceVide(i, j, Piece.VIDE);
	    }
	    
	    for(int i = 6; i < 8; i++){
		if (n % 2 == 1)
		    Plateau.plateau[i][j] = new PieceCarree(i, j, Piece.NOIR);
		else
		    Plateau.plateau[i][j] = new PieceRonde(i, j, Piece.NOIR);
		n++;
	    }
	    n++;
	}
    }

    /** Affiche le plateau de jeu courant. */
    public String toString()
    {
	String	str = "";

	str += "+ - - - - - - - - +\n";
	for(int i = 0; i < 8; i++) {
	    str += "|";
	    for(int j = 0; j < 8; j++)
		str += " " + Plateau.plateau[i][j].getCode();
	    str += " |\n";
	}
	str += "+ - - - - - - - - +";
	return str;
    }
}