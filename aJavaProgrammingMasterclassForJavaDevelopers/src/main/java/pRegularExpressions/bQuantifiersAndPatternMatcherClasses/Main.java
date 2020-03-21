package pRegularExpressions.bQuantifiersAndPatternMatcherClasses;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        // https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html
        // https://docs.oracle.com/javase/8/docs/api/java/util/regex/Matcher.html

        String alphanumeric = "abcDeeeF12abcDeeeGhhiiiijjjkl99z";

        System.out.println(alphanumeric.replaceAll("^abcDeee", "[YYY]"));

        // QUANTIFIERS
        // the "{3}" quantifier expects 3 "eee" in order to match
        System.out.println(alphanumeric.replaceAll("^abcDe{3}", "[YYY]"));
        // "*" quantifier is used to match the string "abcDeee" if it has 1 or more e's
        System.out.println(alphanumeric.replaceAll("^abcDe+", "[YYY]"));
        // "*" quantifier is used to match the string "abcDeee" if it has 0 or more e's
        System.out.println(alphanumeric.replaceAll("^abcDe*", "[YYY]"));
        // "{2,5}" quantifier matches string that begin with "abcD" followed by 2 to 5 "e"'s
        System.out.println(alphanumeric.replaceAll("^abcDe{2,5}", "[YYY]"));
        // "h+i*j" replaces all the instances of "h" followed by 0 or more "i"'s followed by "j"
        System.out.println(alphanumeric.replaceAll("h+i*j", "[XXX]"));

        //PATTERN & MATCHER
        StringBuilder htmlText = new StringBuilder("<h1>My Heading</h1>");
        htmlText.append("<h2>Sub-heading</h2>");
        htmlText.append("<p>This is a paragraph about something.</p>");
        htmlText.append("<p>This is another paragraph about something else.</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<h2></h2>");
        htmlText.append("<p>Here is the summary.</p>");

        // We have to match the entire string so we are using the "." character class witch matches all characters and the "*" quantifier which matches one or more
        // in other words we are saying it could be anything before and after the "<h2>"
        String h2Pattern = ".*<h2>.*";
        Pattern pattern = Pattern.compile(h2Pattern, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());

        h2Pattern = "<h2>";
        pattern = Pattern.compile(h2Pattern);
        matcher = pattern.matcher(htmlText);
        //matcher.reset();
        int count = 0;

        while (matcher.find()) {
            count++;
            System.out.println("Occurrence " + count + " : " + matcher.start() + " to " + matcher.end());
        }
// ****************************************************************************************************************
        h2Pattern = "(<h2>)";
        pattern = Pattern.compile(h2Pattern);
        matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());

        matcher.reset();

        while (matcher.find()) {
            System.out.println("Occurrence : " + matcher.group(1));
        }
// ****************************************************************************************************************
        // GREEDY QUANTIFIER
        System.out.println("\n Greedy Quantifier");
        h2Pattern = "(<h2>.*</h2>)";
        pattern = Pattern.compile(h2Pattern);
        matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());

        matcher.reset();

        while (matcher.find()) {
            System.out.println("Occurrence : " + matcher.group(1));
        }
// ****************************************************************************************************************
        // LAZY QUANTIFIER
        System.out.println("\n Lazy Quantifier with empty text between \"<h2></h2>\"");
        h2Pattern = "(<h2>.*?</h2>)";
        pattern = Pattern.compile(h2Pattern);
        matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());

        matcher.reset();

        while (matcher.find()) {
            System.out.println("Occurrence : " + matcher.group(1));
        }
// ****************************************************************************************************************
        // LAZY QUANTIFIER not taking into account strings without text between "<h2></h2>"
        System.out.println("\n Lazy Quantifier without empty text between \"<h2></h2>\"");
        h2Pattern = "(<h2>.+?</h2>)";
        pattern = Pattern.compile(h2Pattern);
        matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());

        matcher.reset();

        while (matcher.find()) {
            System.out.println("Occurrence : " + matcher.group(1));
        }
// ****************************************************************************************************************
        // LAZY QUANTIFIER groups "(<h2>)(.+?)(</h2>)"
        // Prints only the content between the "<h2></h2>"
        System.out.println("\n Groups Matcher");
        String h2TextGroups = "(<h2>)(.+?)(</h2>)";

        Pattern h2TextPattern = Pattern.compile(h2TextGroups);
        Matcher h2TextMatcher = h2TextPattern.matcher(htmlText);

        while (h2TextMatcher.find()) {
            System.out.println("Occurrence : " + h2TextMatcher.group(2));
        }
    }
}
