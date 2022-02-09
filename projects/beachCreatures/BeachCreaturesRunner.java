/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Cay Horstmann
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 */

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;

/**
 * This class runs a world that contains box bugs. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class BeachCreaturesRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld(new BoundedGrid<>(30,30));
        
        LonelyChameleon lonely = new LonelyChameleon();
        world.add(new Location(2, 2), lonely);

        NearsightedChameleon near = new NearsightedChameleon();
        world.add(new Location(4, 2), near);

        TownCrier crier = new TownCrier(1);
        world.add(new Location(6, 2), crier);

        System.out.println(crier.toString());

        world.show();
    }
}