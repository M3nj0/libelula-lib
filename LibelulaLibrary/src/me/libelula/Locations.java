/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.libelula;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TreeMap;
import org.bukkit.Location;

/**
 *
 * @author Menjo
 */
public class Locations {

    private TreeMap<Integer, Location> keyLocation;
    private Iterator<Location> LocationIterator;

    public Locations() {
        keyLocation = new TreeMap<>();
        LocationIterator = keyLocation.values().iterator();
    }

    /**
     * Adds a location to the list
     *
     * @param key Must not be repeated
     * @param location The location to be inserted
     * @return True when inserted, False if key already exists
     */
    public boolean addLocation(int key, Location location) {
        boolean result = true;
        if (keyLocation.containsKey(key)) {
            result = false;
        } else {
            keyLocation.put(key, location);
            LocationIterator = keyLocation.values().iterator();
        }
        return result;
    }

    /**
     * Adds a location to the list
     *
     * @param location The location to be inserted
     */
    public void addLocation(Location location) {
        Integer key;
        try {
            key = keyLocation.lastKey() + 1;
        } catch (NoSuchElementException e) {
            key = 0;
        }
        keyLocation.put(key, location);
        LocationIterator = keyLocation.values().iterator();
    }

    /**
     * Compares two locations given by parameters
     *
     * @param loc1 First location
     * @param loc2 Second location
     * @return True if locations are the same, false if not
     */
    public static boolean isSameLocation(Location loc1, Location loc2) {
        boolean result = false;
        if (loc1.getX() == loc2.getX()
                && loc1.getY() == loc2.getY()
                && loc1.getZ() == loc2.getZ()
                && loc1.getPitch() == loc2.getPitch()
                && loc1.getYaw() == loc2.getYaw()
                && loc1.getWorld().getName().equals(loc2.getWorld().getName())) {
            result = true;
        }
        return result;
    }

    /**
     * Compares two block locations given by parameters
     *
     * @param loc1 First block location
     * @param loc2 Second block location
     * @return True if block locations are the same, false if not
     */
    public static boolean isSameBlockLocation(Location loc1, Location loc2) {
        boolean result = false;
        if (loc1.getBlockX() == loc2.getBlockX()
                && loc1.getBlockY() == loc2.getBlockY()
                && loc1.getBlockZ() == loc2.getBlockZ()
                && loc1.getWorld().getName().equals(loc2.getWorld().getName())) {
            result = true;
        }
        return result;
    }

    private boolean hasLocation(Location location, boolean precise) {
        boolean result = false;

        if (precise) {
            for (Location loc : keyLocation.values()) {
                if (isSameLocation(loc, location)) {
                    result = true;
                    break;
                }
            }
        } else {
            for (Location loc : keyLocation.values()) {
                if (isSameBlockLocation(loc, location)) {
                    result = true;
                    break;
                }
            }
        }

        return result;
    }

    /**
     * checks if the object contains a location
     *
     * @param location given location
     * @return true if location exists, false if not
     */
    public boolean hasLocation(Location location) {
        return hasLocation(location, true);
    }

    /**
     * checks if the object contains a block location
     *
     * @param location given block location
     * @return true if block location exists, false if not
     */
    public boolean hasBlockLocation(Location location) {
        return hasLocation(location, false);
    }

    /**
     * implements a circular list with the locations 
     * @return next location from list and first one after last one. If list is empty returns null
     */
    public Location getNextLocation() {
        Location result = null;
        if (!keyLocation.isEmpty()) {
            if (!LocationIterator.hasNext()) {
                LocationIterator = keyLocation.values().iterator();
            }
            result = LocationIterator.next();
        }
        return result;
    }

}
