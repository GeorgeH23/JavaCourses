package jJavaCollections.hImmutableClasses;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Map<String, Integer> tempExit = new HashMap<>();
        locations.put(0, new Location(0,"You are sitting in front of a computer, learning Java",null));

        tempExit = new HashMap<>();
        // Directions available from location 1
        tempExit.put("W",2);
        tempExit.put("E",3);
        tempExit.put("S",4);
        tempExit.put("N",5);
        locations.put(1, new Location(1,"You are standing at the end of a road before a small brick building.",tempExit));

        tempExit = new HashMap<>();
        // Directions available from location 2
        tempExit.put("N",5);
        locations.put(2, new Location(2,"You are at the top of a hill",tempExit));

        tempExit = new HashMap<>();
        // Directions available from location 3
        tempExit.put("W",1);
        locations.put(3, new Location(3,"You are inside a building, a well house for a small spring.",tempExit));

        tempExit = new HashMap<>();
        // Directions available from location 4
        tempExit.put("N",1);
        tempExit.put("W",2);
        locations.put(4, new Location(4,"You are in a valley beside a stream.",tempExit));

        tempExit = new HashMap<>();
        // Directions available from location 5
        tempExit.put("S",1);
        tempExit.put("W",2);
        locations.put(5, new Location(5,"You are in the forest!",tempExit));

        int loc = 1;
        while (true) {
            System.out.println(locations.get(loc).getDescription());
//############################################################################################

            tempExit.remove("S");                       // Even if you try, you CANNOT REMOVE
            locations.get(5).getExits().remove("S");    // the exits for our locations

//###########################################################################################

            if (loc == 0) {
                break;
            }

            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.print("Where do you want to go? Available exits are: ");
            for (String exit : exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();

            String direction = scanner.nextLine().toUpperCase();
            if (direction.contains("SOUTH")) {
                direction = "S";
            } else if (direction.contains("NORTH")) {
                direction = "N";
            } else if (direction.contains("EAST")) {
                direction = "E";
            } else if (direction.contains("WEST")) {
                direction = "W";
            } else if (direction.contains("QUIT")) {
                direction = "Q";
            }

            if (exits.containsKey(direction)){
                loc = exits.get(direction);
            } else {
                System.out.println("You cannot go in that direction.");
            }
        }

        System.out.println(locations.get(1).getExits());
        for (Map.Entry entry : tempExit.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

       // for (int i = 0; i++ <10; System.out.println(i + ".Sug pula singur!"));
    }



}
