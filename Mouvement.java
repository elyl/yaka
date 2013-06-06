/** Gestion des mouvements. */
public class Mouvement
{
    private int	deltaX;
    private int	deltaY;

    /** Initialise un mouvement. */
    public Mouvement(int deltaX, int deltaY)
    {
	this.deltaX = deltaX;
	this.deltaY = deltaY;
    }

    /** Retourne la distance horizontale du mouvement courant. */
    public int getDeltaX()
    {
	return (this.deltaX);
    }

    /** Retourne la distance verticale du mouvement courant. */
    public int getDeltaY()
    {
	return (this.deltaY);
    }

    /** Affiche les caracteristiques du mouvement courant. */
    public String toString()
    {
	return ("deltaX : " + this.deltaX + ", deltaY : " + this.deltaY);
    }
}