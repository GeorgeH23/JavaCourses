package lBasicIO.kRandomAccessFileClass;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Locations locations = new Locations();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        // Written to work with R.A.F.
        Location currentLocation = locations.getLocation(1);
        while (true) {
            //System.out.println(locations.get(loc).getDescription());
            System.out.println(currentLocation.getDescription());

            if (currentLocation.getLocationID() == 0) {
                break;
            }

            Map<String, Integer> exits = currentLocation.getExits();
            System.out.print("Where do you want to go? Available exits are: ");
            for (String exit : exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();

            String direction = scanner.nextLine().toUpperCase();
            if (direction.contains("QUIT")) {
                direction = "Q";
            } else if (direction.contains("SOUTH")) {
                direction = "S";
            } else if (direction.contains("NORTH")) {
                direction = "N";
            } else if (direction.contains("EAST")) {
                direction = "E";
            } else if (direction.contains("WEST")) {
                direction = "W";
            } else if (direction.contains("NORTH EAST")){
                direction = "NE";
            } else if (direction.contains("NORTH WEST")){
                direction = "NW";
            } else if (direction.contains("SOUTH EAST")){
                direction = "SE";
            } else if (direction.contains("SOUTH WEST")){
                direction = "SW";
            } else if (direction.contains("DOWN")){
                direction = "D";
            } else if (direction.contains("UP")){
                direction = "U";
            }

            if (exits.containsKey(direction)) {
                currentLocation = locations.getLocation(currentLocation.getExits().get(direction));
            } else {
                System.out.println("You cannot go in that direction.");
            }
        }
        locations.close();
    }
}
