package lBasicIO.jObjectInputOutputIncludinSerialization;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public final class Location implements Serializable {
    private final int locationID;
    private final String description;
    private final Map<String,Integer> exits;

    // this is for serialization
    //Without this the serialization won't work
    private long serialVersionUID = 1L;

    public Location(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;

        if (exits != null){                                 // This is done in order
        this.exits = new LinkedHashMap<String, Integer>(exits);   // te prevent a NullPointerException
        } else {                                            // which will crash the program at runtime
            this.exits = new LinkedHashMap<String, Integer>();    // if we pass a NULL exits Map to the constructor
        }

        this.exits.put("Q", 0);
    }

    /*public void addExit(String direction, int location){
        exits.put(direction,location);
    }*/

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
            return description;
    }

    public Map<String, Integer> getExits() {
        return new LinkedHashMap<String, Integer>(exits); //We don't return our MAP but a COPY of this.exits
                                                    // so nothing outside the class can modify our
                                                    // original Map
    }

    // Added for BufferedReader program to work. It adds the locations it reads from the directions.txt file
    protected void addExit(String direction, int location){
        exits.put(direction, location);
    }
}
