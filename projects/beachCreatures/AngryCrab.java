import java.util.ArrayList;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;

public class AngryCrab extends CrabCritter
{
    public void processActors(ArrayList<Actor> actors)
    {
        for (Actor a : actors)
        {
            int[] offset = getOffset(a, this); // get offset from crab
            Location destination = new Location(
                                    a.getLocation().getRow() + offset[0], 
                                    a.getLocation().getCol() + offset[1] ); // move along offset
            if (getGrid().isValid(destination)) {
                a.moveTo(destination);
            } else {
                a.removeSelfFromGrid();
            }                                    
        }
    }
    // get an offset for an actor by a reference point
    public int[] getOffset(Actor subject, Actor reference) {
        int[] offset = {0, 0};
        Location subj_loc = subject.getLocation();
        Location ref_loc = reference.getLocation();

        offset[0] = ref_loc.getRow() - subj_loc.getRow();
        offset[1] = ref_loc.getCol() - subj_loc.getCol();
        return offset;
    }
}
