/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.libelula;

import java.util.TreeMap;
import org.bukkit.Location;

/**
 *
 * @author Menjo
 */
public class Locations {
    
    TreeMap<Integer, Location> keyLocation;

    public Locations() {
        keyLocation = new TreeMap<>();
    }

    /**
     * Adds a location to the list
     * @param key Must not be repeated
     * @param location The location to be inserted
     * @return True when inserted, False if key already exists
     */
    public boolean addLocation (int key, Location location) {
        boolean result = true;
        if (keyLocation.containsKey(key)){
            result = false;
        } else {
            keyLocation.put(key, location);
        }
        return result;
    }
    
     /**
     * Adds a location to the list
     * @param location The location to be inserted
     */
    public void addLocation (Location location) {
        Integer key = keyLocation.lastKey();
        if (key != null) {
            key++;
        } else {
            key = 0;
        }
        keyLocation.put(key, location);
    }
    
}

