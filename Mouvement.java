public class Mouvement
{
    private int	deltaX;
    private int	deltaY;

    public Mouvement(int deltaX, int deltaY)
    {
	this.deltaX = deltaX;
	this.deltaY = deltaY;
    }

    public int getDeltaX()
    {
	return (this.deltaX);
    }

    public int getDeltaY()
    {
	return (this.deltaY);
    }
}