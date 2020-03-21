package nLambdaExpressions.hChallenges;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        Runnable runnable = () -> {
            String myString = "Let's split this up into an array.";
            String[] parts = myString.split(" ");
            for (String part : parts) {
                System.out.println(part);
            }
        };

        Thread t1 = new Thread(runnable);
        //t1.start();

        Function<String, String> everySecondChar = s -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < s.length(); i++){
                if (i % 2 == 1) {
                    returnVal.append(s.charAt(i));
                }
            }
            return returnVal.toString();
        };

        System.out.println(everySecondChar.apply("1234567890"));
        System.out.println(print("Aaoolleeoouu!!", everySecondChar));

        Supplier<String> supplier = () -> "I love Java!";

        String supplierResult = supplier.get();

        System.out.println(supplierResult);

        List<String> topNames2015 = Arrays.asList("Amelia", "Olivia", "emily", "Isla", "Ava", "oliver", "Jack", "Charlie", "harry", "Jacob");

        long namesWithA = topNames2015.stream()
                                    .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                                    .sorted(String::compareTo)
                                    .peek(System.out::println)
                                    .filter(name -> name.startsWith("A"))
                                    .count();
        System.out.println("\nNumber of names starting with A = " + namesWithA);
    }

    public static String print(String input, Function<String, String> function) {
        return function.apply(input);
    }

}
