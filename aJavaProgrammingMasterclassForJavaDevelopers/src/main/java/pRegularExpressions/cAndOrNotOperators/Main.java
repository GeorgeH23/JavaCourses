package pRegularExpressions.cAndOrNotOperators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        System.out.println("harry".replaceAll("[H|h]arry", "Larry"));
        System.out.println("Harry".replaceAll("[H|h]arry", "Larry"));

        // NOT Operator "[^abc]" the carrot "^" character means NOT when is the first char between square brackets

        // "!" is also not but in the context of a negative lookahead expression

        String tvTest = "tstvtkt";
        System.out.println("Matches all the \"t\"'s followed by any character, except \"v\" (\"ts\", \"tk\")");
        String tNotVregExp = "t[^v]";
        // Matches all the "t"'s followed by any character, except "v" ("ts", "tk")
        Pattern tNotVpattern = Pattern.compile(tNotVregExp);
        Matcher tNotVMatcher = tNotVpattern.matcher(tvTest);

        int count = 0;
        while (tNotVMatcher.find()) {
            count++;
            System.out.println("Occurrence " + count + " : " + tNotVMatcher.start() + " to " + tNotVMatcher.end());
        }

        System.out.println("This also matches the \"t\" at the end of tvTest String");
        // This also matches the "t" at the end of tvTest String. This will match all the "t"'s in the tvTest String.
        // When using a lookahead the characters in the expression ar not part of the match
        // Lookahead expressions don't consume the characters they match. They don't include the characters they match in the matched text
        tNotVregExp = "t(?!v)";
        tNotVpattern = Pattern.compile(tNotVregExp);
        tNotVMatcher = tNotVpattern.matcher(tvTest);

        count = 0;
        while (tNotVMatcher.find()) {
            count++;
            System.out.println("Occurrence " + count + " : " + tNotVMatcher.start() + " to " + tNotVMatcher.end());
        }

        System.out.println("This matches all \"t\"'s followed by \"v\"'s without including the \"v\"'s in the match");
        // Positive lookahead if we want to match all "t"'s followed by "v"'s without including the "v"'s in the match
        tNotVregExp = "t(?=v)";
        tNotVpattern = Pattern.compile(tNotVregExp);
        tNotVMatcher = tNotVpattern.matcher(tvTest);

        count = 0;
        while (tNotVMatcher.find()) {
            count++;
            System.out.println("Occurrence " + count + " : " + tNotVMatcher.start() + " to " + tNotVMatcher.end());
        }

        // ^([\(]{1}[0-9]{3}[\)]{1}[ ]{1}[0-9]{3}[\-]{1}[0-9]{4})$
        // This matches a US number ex: (800) 123-4567

        String phone1 = "1234567890"; // Shouldn't match
        String phone2 = "(123) 456-7890"; // match
        String phone3 = "123 456-7890"; // Shouldn't match
        String phone4 = "(123)456-7890"; // Shouldn't match

        System.out.println("phone 1= " + phone1.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("phone 2= " + phone2.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("phone 3= " + phone3.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("phone 4= " + phone4.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));

        // ^4[0-9]{12}([0-9]{3})?$   matches a Visa card number
        // any Visa card number starts with a 4 followed by 12 numbers followed by 0 or 1 groups of 3 numbers


    }
}
