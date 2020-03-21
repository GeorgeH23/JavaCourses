package qDebuggingAndUnitTesting.aIntroductionToDebugging;

public class StringUtilities {

    private StringBuilder stringBuilder = new StringBuilder();
    private int charsAdded = 0;

    public void addChar(StringBuilder sb, char chr) {
        sb.append(chr);
        //sb.append(chr);
        charsAdded++;
    }

    public String upperAndPrefix(String str) {
        String upper = str.toUpperCase();
        return "Prefix_" + upper;
    }

    public String addSuffix(String str) {
        return str + "_Suffix";
    }
}
