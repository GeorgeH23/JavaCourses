package nLambdaExpressions.xExceptionHandlingInLambdas;


import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class CheckedExceptions {

    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(3, 9, 7, 0, 10, 20);
        integers.stream()
                .sorted()
                .forEach(throwingConsumerWrapper(CheckedExceptions::writeToFile, IOException.class));
    }

    private static <T, E extends Exception> Consumer<T> throwingConsumerWrapper(ThrowingConsumer<T, E> throwingConsumer, Class<E> exceptionClass) {
        return i -> {
            try {
                throwingConsumer.accept(i);
            } catch (Exception ex) {
                try {
                    E exCast = exceptionClass.cast(ex);
                    System.err.println("Exception occured : " + exCast.getMessage());
                } catch (ClassCastException ccEx) {
                    throw new RuntimeException(ex);
                }
            }
        };
    }

    private static void writeToFile(int i) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("writer.txt"));
        String line;
        StringBuilder sb = new StringBuilder();

        while ((line = br.readLine()) != null) {
            sb.append(line);
            sb.append("\n");
        }
        System.out.println(sb.toString());

        BufferedWriter bwr = new BufferedWriter(new FileWriter("writer.txt"));

        bwr.write(sb.toString() + i + " is the number.");
        System.out.println("Written to file: " + i);
        bwr.close();
        br.close();
    }
}
