/** Gestion du plateau de jeu. */
public class Plateau
{
    public static Piece plateau[][];

    /** Initialise un plateau de jeu vide. */
    public Plateau()
    {
	Plateau.plateau = new Piece[8][8];
    }

    /** Initialise le plateau de jeu courant. */
    public void initialize()
    {
	int	i;
	int	j;

	i = 0;
	while (i < 8)
	    {
		j = 0;
		while (j < 8)
		    {
			if (i == 6)
			    if (j % 2 == 1)
				Plateau.plateau[i][j] = new PieceCarree(i, j, Piece.NOIR);
			    else
				Plateau.plateau[i][j] = new PieceRonde(i, j, Piece.NOIR);
			else if (i == 7)
			    if (j % 2 == 1)
				Plateau.plateau[i][j] = new PieceRonde(i, j, Piece.NOIR);
			    else
				Plateau.plateau[i][j] = new PieceCarree(i, j, Piece.NOIR);
			else if (i == 0)
			    if (j % 2 == 1)
				Plateau.plateau[i][j] = new PieceCarree(i, j, Piece.BLANC);
			    else
				Plateau.plateau[i][j] = new PieceRonde(i, j, Piece.BLANC);
			else if (i == 1)
			    if (j % 2 == 1)
				Plateau.plateau[i][j] = new PieceRonde(i, j, Piece.BLANC);
			    else
				Plateau.plateau[i][j] = new PieceCarree(i, j, Piece.BLANC);
			else
			    Plateau.plateau[i][j] = new PieceVide(i, j, Piece.VIDE);
			j++;
		    }
		i++;
	    }
    }

    /** Affiche le plateau de jeu courant. */
    public String toString()
    {
	String	str;
	int	i;
	int	j;

	str = "";
	i = 0;
	while (i < 10)
	    {
		j = 0;
		while (j < 11)
		    {
			if (i == 0 || i == 9)
			    if (j == 0 || j == 10)
				str = str + " ";
			    else
				str = str + "_";
			else
			    if (j == 0)
				str = str + i;
			    else if (j == 1 || j == 10)
				str = str + "|";
			    else
				str = str + Plateau.plateau[i - 1][j - 2].getCode() + " ";
			j++;
		    }
		str = str + "\n";
		i++;
	    }
	return (str);
    }
}