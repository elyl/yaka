/** Gestion des mouvements. */
public class Mouvement
{
    private int	deltaX;
    private int	deltaY;
    private int amplitude;

    public Mouvement(int deltaX, int deltaY, int amplitude)
    {
	this.deltaX = deltaX;
	this.deltaY = deltaY;
	this.amplitude = amplitude;
    }

    /** Initialise un mouvement. */
    public Mouvement(int deltaX, int deltaY)
    {
	this.deltaX = deltaX;
	this.deltaY = deltaY;
	this.amplitude = 1;
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

    public int getAmplitude()
    {
	return (this.amplitude);
    }

    public void setAmplitude(int amplitude)
    {
	this.amplitude = amplitude;
    }

    public boolean equals(Mouvement m)
    {
	return m.getDeltaX() == deltaX && m.getDeltaY() == deltaY;
    }
    
    /** Affiche les caracteristiques du mouvement courant. */
    public String toString()
    {
	return ("deltaX : " + this.deltaX + ", deltaY : " + this.deltaY + ", amplitude : " + this.amplitude);
    }
}