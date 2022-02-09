import info.gridworld.grid.Location;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;

import java.util.ArrayList;

public class RockMason extends Actor
{
    private boolean underground = false;

    /** main act function. if not underground, tries to put in rocks */
    public void act()
    {
        if (!underground) {
            ArrayList<Location> spaces = getEmptySpots();
            if (spaces.size() <= 0) {
                move();
            } else {
                for (int i = 0; i < 2; i++) {
                    Rock r = new Rock();
                    if (i < spaces.size()) {
                    r.putSelfInGrid(getGrid(), spaces.get(i));
                    }
                }
            }
        } else {
            move();
        }
    }

    /** get all empty adjacent spots  */
    public ArrayList<Location> getEmptySpots()
    {
        return getGrid().getEmptyAdjacentLocations(getLocation());
    }

    /** picks a random spot. if no spots are available, go underground */
    public void move() {
        int grid_rows = getGrid().getNumRows();
        int grid_cols = getGrid().getNumCols();
        if (getGrid().getOccupiedLocations().size() >= grid_rows*grid_cols) {
            underground = true;
            return;
        } else {
            underground = false;
            Location l = new Location((int) (Math.random() * grid_rows), (int) (Math.random() * grid_cols));
            while (getGrid().getOccupiedLocations().contains(l)) {
                l = new Location((int) (Math.random() * grid_rows), (int) (Math.random() * grid_cols));
            }
            this.moveTo(l);
        }
    }

}
