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

    public Mouvement(int deltaX, int deltaY)
    {
	this.deltaX = deltaX;
	this.deltaY = deltaY;
	this.amplitude = 1;
    }

    public int getDeltaX()
    {
	return (this.deltaX);
    }

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

    public String toString()
    {
	return ("deltaX : " + this.deltaX + ", deltaY : " + this.deltaY + ", amplitude : " + this.amplitude);
    }
}