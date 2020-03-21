package lBasicIO.aExceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        int x = 98;
        int y = 0;
        System.out.println(divideLookBeforeYouLeap(x,y));
        System.out.println(divideAskForForgivenessThenPermission(x,y));
        //System.out.println(divide(x,y));

        int z = getInt();
        System.out.println("z is: " + z);

        z = getIntLBYL();
        System.out.println("z is: " + z);

        z = getIntEAFP();
        System.out.println("z is: " + z);
    }

    private static int getInt(){
        System.out.println("Enter number: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static int getIntLBYL(){
        Scanner scanner = new Scanner(System.in);
        boolean isValid = true;
        System.out.println("Please enter an integer:");
        String input = scanner.next();
        for (int i = 0; i < input.length(); i++){
            if (!Character.isDigit(input.charAt(i))){
                isValid = false;
                break;
            }
        }
        if (isValid) {
            return Integer.parseInt(input);
        }
        return -1;
    }

    private static int getIntEAFP() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter an integer:");
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e){
            e.printStackTrace();
            return -1;
        }
    }

    private static int divideLookBeforeYouLeap(int x, int y){
        if (y != 0) {
            return x / y;
        } else {
            return 0;
        }
    }

    private static int divideAskForForgivenessThenPermission(int x, int y){
        try {
            return x / y;
        } catch (ArithmeticException e){
            return 0;
        }
    }

    private static int divide(int x, int y){
        return x / y;
    }
}
