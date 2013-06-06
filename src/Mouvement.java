public class Mouvement
{
    private int	deltaX;
    private int	deltaY;
    private int amplitude;

    public Mouvement(int deltaX, int deltaY)
    {
	Mouvement(deltaX, deltaY, 1);
    
    public Mouvement(int deltaX, int deltaY, int amplitude)
    {
	this.deltaX = deltaX;
	this.deltaY = deltaY;
	this.amplitude = amplitude;
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

    public String toString()
    {
	return ("deltaX : " + this.deltaX + ", deltaY : " + this.deltaY + ", amplitude: " + this.amplitude);
    }
}