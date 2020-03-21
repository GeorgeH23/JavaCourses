package nLambdaExpressions.fStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        // https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html
        // https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html

        List<String> someBingoNumbers = Arrays.asList(
                "N40", "N36",
                "B12", "B6",
                "G53", "G49", "G60", "G50", "g64",
                "I26", "I17", "I29",
                "O71");
        List<String> gNumbers = new ArrayList<>();

        // Old way of doing it.

       /* someBingoNumbers.forEach(number -> {
            if (number.toUpperCase().startsWith("G")) {
                gNumbers.add(number);
            }
        });

        gNumbers.sort((String s1, String s2) -> s1.compareTo(s2));
        gNumbers.forEach((String s) -> System.out.println(s));*/

       // New way of doing it with Streams

        someBingoNumbers.stream()
                        //.map(s -> s.toUpperCase())
                        .map(String::toUpperCase)
                        .filter(s -> s.startsWith("G"))
                        .sorted()
                        //.forEach(s -> System.out.println(s))
                        .forEach(System.out::println);

        System.out.println();

        Stream<String> ioNumberStream = Stream.of("I26", "I17", "I29", "O71");
        Stream<String> inNumberStream = Stream.of("N40", "N36", "I26", "I17", "I29", "O71");
        // The .concat() method is static so it can't be used in a chain
        Stream<String> concatStream = Stream.concat(ioNumberStream,inNumberStream);
        // but it can be used as a source for a chain
        //System.out.println(concatStream.distinct().count());
        System.out.println(concatStream.distinct().peek(System.out::println).count());
        //concatStream.map(String::toLowerCase).filter(s -> s.startsWith("1")).sorted().forEach(System.out::println);

    }
}
