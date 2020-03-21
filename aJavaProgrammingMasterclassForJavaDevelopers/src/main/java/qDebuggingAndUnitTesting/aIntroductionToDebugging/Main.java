package qDebuggingAndUnitTesting.aIntroductionToDebugging;

public class Main {

    public static void main(String[] args) {

        // https://sites.google.com/site/piotrwendykier/software/jtransforms

        StringUtilities utils = new StringUtilities();
        StringBuilder sb = new StringBuilder();

        while (sb.length() < 10){
            utils.addChar(sb, 'a');
        }
        System.out.println(sb);

        String str = "abcdefg";
        String result = utils.upperAndPrefix(utils.addSuffix(str));
    }
}
