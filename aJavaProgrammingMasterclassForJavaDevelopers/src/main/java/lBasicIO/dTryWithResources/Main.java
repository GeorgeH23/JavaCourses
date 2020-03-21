package lBasicIO.dTryWithResources;

import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Locations locations = new Locations();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int loc = 1;
        while (true) {
            System.out.println(locations.get(loc).getDescription());

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

            if (exits.containsKey(direction)) {
                loc = exits.get(direction);
            } else {
                System.out.println("You cannot go in that direction.");
            }
        }
    }
}
