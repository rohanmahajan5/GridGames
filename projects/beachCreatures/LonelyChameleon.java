import java.util.ArrayList;
import java.awt.Color;
import info.gridworld.actor.Actor;

public class LonelyChameleon extends ChameleonCritter
{
    private static final double DARKENING_FACTOR = 0.5;
    public void processActors(ArrayList<Actor> actors)
    {
        int n = actors.size();

        if (n == 0){
            Color c = getColor();
            int red = (int) (c.getRed() * (1 - DARKENING_FACTOR));
            int green = (int) (c.getGreen() * (1 - DARKENING_FACTOR));
            int blue = (int) (c.getBlue() * (1 - DARKENING_FACTOR));
            setColor(new Color(red, green, blue));
        }else{
            int r = (int) (Math.random() * n);
            Actor other = actors.get(r);
            setColor(other.getColor());
        }
    }
}
