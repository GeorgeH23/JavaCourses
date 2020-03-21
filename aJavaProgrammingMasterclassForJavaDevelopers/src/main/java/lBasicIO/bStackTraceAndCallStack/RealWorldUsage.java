package lBasicIO.bStackTraceAndCallStack;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class RealWorldUsage {

    public static void main(String[] args) {

        try {
            int result = divide();
            System.out.println(result);
            // Catching multiple exceptions using bitwise or "|"
        } catch (ArithmeticException | NoSuchElementException e) {
            System.out.println(e.toString());
            System.out.println("Unable to perform a division, autopilot shutting down.");
        }


    }

    private static int divide(){
        int x = getInt();
        int y = getInt();
        System.out.println("x is: " + x + ", y is: " + y);
        return x / y;
    }

    private static int getInt(){
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter an integer");
        while (true) {
            try {
                return s.nextInt();
            } catch (InputMismatchException e){
                // go round again. Read past the end of line in the input first
                s.nextLine();
                System.out.println("Please enter a number using only the digits 0 to 9.");
            }
        }
    }
}
