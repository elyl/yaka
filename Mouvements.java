public class Mouvements
{
    public static final Mouvement RIGHT = new Mouvement(0, 1);
    public static final Mouvement LEFT = new Mouvement(0, -1);
    public static final Mouvement AHEAD = new Mouvement(1, 0);
    public static final Mouvement RIGHT_AHEAD = new Mouvement(1, 1);
    public static final Mouvement LEFT_AHEAD = new Mouvement(1, -1);

    public static final Mouvement NO_MOVE[] = {};
    public static final Mouvement SQUARE_MOVE[] = {AHEAD, LEFT, RIGHT};
    public static final Mouvement ROUND_MOVE[] = {RIGHT_AHEAD, LEFT_AHEAD};
}