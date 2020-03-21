package pRegularExpressions.zChallenge;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        // https://docs.oracle.com/javase/8/docs/api/java/util/regex/Matcher.html

        String challenge1 = "I want a bike.";
        System.out.println(challenge1.matches("I want a bike."));

        String regEXp = "I want a \\w+.";
        System.out.println(challenge1.matches(regEXp));
        String challenge2 = "I want a ball.";
        System.out.println(challenge2.matches(regEXp));

        String regExp1 = "I want a (bike|ball).";
        System.out.println(challenge1.matches(regExp1));
        System.out.println(challenge2.matches(regExp1));

        String regEXp3 = "I want a \\w+.";
        Pattern pattern = Pattern.compile(regEXp3);
        Matcher matcher = pattern.matcher(challenge1);
        System.out.println(matcher.matches());

        matcher = pattern.matcher(challenge2);
        System.out.println(matcher.matches());

        String challenge4 = "Replace all blanks with underscores.";
        System.out.println(challenge4.replaceAll(" ", "_"));
        System.out.println(challenge4.replaceAll("\\s", "_"));

        String challenge5 = "aaabccccccccdddefffg";
        System.out.println(challenge5.matches("^([a]{3})([b]{1})([c]{8})([d]{3})([e]{1})([f]{3})([g]{1})$"));
        System.out.println(challenge5.matches("^a{3}bc{8}d{3}ef{3}g$"));
        System.out.println(challenge5.matches("[abcdefg]+"));
        System.out.println(challenge5.matches("[a-g]+"));

        String challenge6 = "axbcd.135";
        System.out.println(challenge6.matches("^([a-z]+).([0-9]+)$"));
        System.out.println(challenge6.matches("^[A-z][a-z]+\\.\\d+$"));

        String challenge7 = "abcd.135uvqz.7tzik.999";
        System.out.println(challenge7.matches("^[A-z][a-z]+\\.\\d+[A-z][a-z]+\\.\\d+[A-z][a-z]+\\.\\d+$"));
        String pat = "([A-z][a-z]+)(\\.)(\\d+)";
        Pattern pattern7 = Pattern.compile("^" + pat + pat + pat + "$");
        Matcher matcher7 = pattern7.matcher(challenge7);
        System.out.println(matcher7.matches());

        pattern7 = Pattern.compile("[A-Za-z]+\\.(\\d+)");
        matcher7 = pattern7.matcher(challenge7);

        while (matcher7.find()){
            System.out.println("Occurrence: " + matcher7.group(1));
        }

        String challenge8 = "abcd.135\tuvqz.7\ttzik.999\n";
        Pattern pattern8 = Pattern.compile("[A-Za-z]+\\.(\\d+)\\s");
        Matcher matcher8 = pattern8.matcher(challenge8);

        while (matcher8.find()){
            System.out.println("Occurrence: " + matcher8.group(1));
        }

        String challenge9 = "abcd.135\tuvqz.7\ttzik.999\n";
        Pattern pattern9 = Pattern.compile("[A-Za-z]+\\.(\\d+)\\s");
        Matcher matcher9 = pattern9.matcher(challenge9);

        while (matcher9.find()){
            System.out.println("Occurrence start index: " + matcher9.start(1) + " occurence end index: " + (matcher9.end(1) - 1));
        }

        String challenge10 = "{0, 2}, {0, 5}, {1, 3}, {2, 4}, {x, y}, {3, 4}, {11, 12}";
        //Pattern pattern10 = Pattern.compile("(\\{[0-9], [0-9]\\})");
        //Pattern pattern10 = Pattern.compile("\\{(.+?)\\}");
        Pattern pattern10 = Pattern.compile("\\{(\\d+, \\d+)\\}");
        Matcher matcher10 = pattern10.matcher(challenge10);

        while (matcher10.find()){
            System.out.println("Occurrence: " + matcher10.group(1));
        }

        String challenge11 = "11111";
        System.out.println(challenge11.matches("^\\d{5}$"));

        String challenge12 = "11111-1111";
        System.out.println(challenge12.matches("^\\d{5}-\\d{4}$"));

        String challenge13 = "11111";
        System.out.println(challenge13.matches("^\\d{5}(-\\d{4})?$"));
    }
}