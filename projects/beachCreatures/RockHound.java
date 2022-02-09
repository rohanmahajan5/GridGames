import info.gridworld.grid.Location;
import info.gridworld.actor.Actor;

import java.util.ArrayList;

public class RockHound extends Actor {
    private static Location target;
    
    /** main act function. manages most of the logic flow 
     * and accesses helper functions. runs in one of either two
     * main ways; if it is near a rock or not.  */
    public void act() {
        ArrayList<Location> nearby_rocks = getNearbyRocks();
        ArrayList<Location> all_rocks = getAllRocks();
        if (nearby_rocks.size() > 0) { // nearby rocks exist
           target = nearby_rocks.get(0);
           Actor r = getGrid().get(target);
           r.removeSelfFromGrid();
        } else if (all_rocks.size() > 0) { // any rocks exist
             // set the target
             target = all_rocks.get(0);
             // face the target
             this.faceLocation(target);
             // move to target
            this.moveTo(this.getLocation().getAdjacentLocation(this.getLocation().getDirectionToward(target)));
             /*int[] normalized_offset = getNormalizedOffset(this.getLocation(), target);
             Location destination = new Location(
                                     this.getLocation().getRow() + normalized_offset[0], 
                                     this.getLocation().getCol() + normalized_offset[1] ); // move along offset
             this.moveTo(destination);*/
        } else { // no rocks
            return;
        }
    }
    /**
     * get all nearby rocks' locations, not the objects themselves
     */
    public ArrayList<Location> getNearbyRocks() {
        ArrayList<Location> neighbors =  getGrid().getOccupiedAdjacentLocations(this.getLocation());
        ArrayList<Location> rocks = new ArrayList<Location>(0);
        for (Location l : neighbors) {
            if (getGrid().get(l).getClass().getName() == "Rock") {
                rocks.add(l);
            }
        }
        return rocks;
    }

    /** get all rocks' locations on the entire grid */
    public ArrayList<Location> getAllRocks() {
        ArrayList<Location> occupied =  getGrid().getOccupiedLocations();
        ArrayList<Location> rocks = new ArrayList<Location>(0);
        for (Location l : occupied) {
            if (getGrid().get(l).getClass().getName() == "Rock") {
                rocks.add(l);
            }
        }
        return rocks;
    }

    /** get offset from a reference Location in a 2d vector */
    public int[] getOffset(Location subject, Location reference) {
        int[] offset = {0, 0};

        offset[0] = subject.getRow() - reference.getRow();
        offset[1] = subject.getCol() - reference.getCol();
        return offset;
    }

    /** calculates offset but each value is either -1, 0, or 1. */
    public int[] getNormalizedOffset(Location subject, Location reference) {
        int[] offset = {0, 0};

        offset[0] = subject.getRow() - reference.getRow();
        offset[1] = subject.getCol() - reference.getCol();

        offset[0] /= Math.abs(offset[0]);
        offset[1] /= Math.abs(offset[1]);

        return offset;
    }

    /** face the location of a target */
    public void faceLocation(Location target) {
        int[] offset = getOffset(this.getLocation(), target);
        int dist = getHypotenuse(offset[0], offset[1]);
        int angle = (int) Math.asin(offset[0]/dist);

        this.setDirection(angle);
    }

    /** get the hypotenuse of a triangle given the other two sides */
    public int getHypotenuse(int a, int b) {
        return (int) Math.pow((Math.pow(a, 2) + Math.pow(b, 2)), 0.5);
    }

    
}
