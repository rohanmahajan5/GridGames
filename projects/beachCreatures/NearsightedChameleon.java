import java.util.ArrayList;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;

public class NearsightedChameleon extends LonelyChameleon
{
    public ArrayList<Actor> getActors()
    {
        ArrayList<Actor> actors = new ArrayList<Actor>();
        int[] dirs =
            {Location.AHEAD, Location.HALF_CIRCLE};
        Location loc = getLocation();
        
        for (int dir: dirs) {
            Location adjacent_loc = loc.getAdjacentLocation(dir);
            if (getGrid().isValid(adjacent_loc)) {
                Actor a = getGrid().get(adjacent_loc);
                if (a != null) {
                    actors.add(a);
                }
            }
        }
        return actors;
    }
}
