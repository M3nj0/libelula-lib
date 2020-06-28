/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.libelula;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_15_R1.CraftWorld;

/**
 *
 * @author Menjo
 */
public class LibelulaLibrary {

    public LibelulaLibrary() {

    }

    public static void main(String[] args) {
        Locations locs = new Locations();
        World world = new CraftWorld(null, null, World.Environment.NETHER);
        for (int i = 0; i < 9; i++) {
            Location l = new Location(world, 1, i, 3);
            locs.addLocation(l);
        }

        for (int i = 0; i < 19; i++) {
            printXYZ(locs.getNextLocation());
        }

    }

    public static void printXYZ(Location l) {

        System.out.print(l.getBlockX());
         System.out.print(" ");
        System.out.print(l.getBlockY());
        System.out.print(" ");
        System.out.println(l.getBlockZ());
    }
}
