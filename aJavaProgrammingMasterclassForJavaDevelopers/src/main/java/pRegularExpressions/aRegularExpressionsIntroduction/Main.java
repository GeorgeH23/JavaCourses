package pRegularExpressions.aRegularExpressionsIntroduction;

public class Main {

    public static void main(String[] args) {

        String alphanumeric = "abcDeeeF12abcDeeeGhhiiiijkl99z";

        // "." matches all the characters
        System.out.println(alphanumeric.replaceAll(".", "Y"));

        System.out.println(alphanumeric.replaceAll("^abcDeee","THE BEGINNING "));
        System.out.println(alphanumeric.replaceAll("99z$"," THE END"));

        System.out.println(alphanumeric.matches("^hello"));
        // the .matches() method returns TRUE if the ENTIRE String matches the regular expression
        System.out.println(alphanumeric.matches("^abcDeee"));
        System.out.println(alphanumeric.matches("^abcDeeeF12abcDeeeGhhiiiijkl99z"));

        // Replaces all the occurrences of the characters between brackets [ abc ] in the entire string
        System.out.println(alphanumeric.replaceAll("[aei]", "X"));
        System.out.println(alphanumeric.replaceAll("[aei]", "[I replaced a letter here]"));

        // Replaces all the occurrences of the characters between brackets [aei] only if they are followed
        // by one of the characters between the second pair of brackets [Fj]
        System.out.println(alphanumeric.replaceAll("[aei][Fj]","[X]"));

        alphanumeric = "I love my husband Harry, he is the best!";
        System.out.println(alphanumeric.replaceAll("[Hh]arry", "John"));

        alphanumeric = "abcDeeeF12abcDeeeGhhiiiijkl99z";
        // "[^ej]" replaces all characters which are NOT "e" or "j"
        System.out.println(alphanumeric.replaceAll("[^ej]","X"));
        System.out.println(alphanumeric.replaceAll("[abcdef345678]","X"));
        System.out.println(alphanumeric.replaceAll("[a-f3-8]", "X"));
        System.out.println(alphanumeric.replaceAll("[a-fA-F3-8]", "X"));
        // (?i) turns off the case sensitivity for a ASCII string
        // (?u) turns off the case sensitivity for a UNICODE string
        System.out.println(alphanumeric.replaceAll("(?i)[a-f3-8]", "X"));

        // "[0-9]" or "\\d" matches all occurrences of numeric characters
        System.out.println(alphanumeric.replaceAll("[0-9]", "[X]"));
        System.out.println(alphanumeric.replaceAll("\\d", "[X]"));

        // "\\D" matches all occurrences of non numeric characters
        System.out.println(alphanumeric.replaceAll("\\D", "[X]"));

        String hasWhitespace = "I have blanks and\ta tab, and also a newLine\n";
        System.out.println(hasWhitespace);
        // "\\s" replaces all the spaces tabs and newlines.
        System.out.println(hasWhitespace.replaceAll("\\s", ""));
        System.out.println(hasWhitespace.replaceAll("\t", "[X]"));

        // "\\" replaces all the non whitespace characters in a string.
        System.out.println(hasWhitespace.replaceAll("\\S", ""));

        System.out.println(alphanumeric.replaceAll("\\w", "[X]"));
        System.out.println(hasWhitespace.replaceAll("\\w", "[X]"));
        System.out.println(hasWhitespace.replaceAll("\\W","[X]"));
        // "\\bQuantifiersAndPatternMatcherClasses" adds desired characters at the beginning and end of every word in the string
        System.out.println(hasWhitespace.replaceAll("\\b","[X]"));
    }
}
