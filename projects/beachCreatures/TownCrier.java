import java.util.ArrayList;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.awt.Color;

public class TownCrier extends Critter
{
    private int t;

    public TownCrier(int t) {
        super();
        this.t = t;
    }

    /** modifies getActors to search in a 2-block radius and only check for Critters */
    public ArrayList<Actor> getActors()
    {
        ArrayList<Actor> actors = new ArrayList<Actor>();
        Location current_loc = getLocation();
        
        for (int i = current_loc.getRow()-2; i <= current_loc.getRow()+2; i++) {
            for (int j = current_loc.getCol()-2; i <= current_loc.getCol()+2; i++) {
                Location observing_loc = new Location(i, j);
                if (getGrid().isValid(observing_loc)) {
                    Actor a = getGrid().get(observing_loc);
                    if (a instanceof Critter) {
                        actors.add(a);
                    }
                }
            }   
        }
        return actors;
        
    }
    
    /** processActors only changes color of the towncrier */
    public void processActors(ArrayList<Actor> actors) {
        if (actors.size() > this.t) {
            setColor(new Color(255, 0, 0));
        } else {
            setColor(new Color(0, 0, 255));
        }
    }

}