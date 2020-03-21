package nLambdaExpressions.xExceptionHandlingInLambdas;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {

        int[] someNumbers = {1, 2, 3, 4};
        int key = 1;

        /*process(someNumbers, key, wrapperLambda((v, k) -> System.out.println(v / k)));

        key = 0;

        process(someNumbers, key, wrapperLambda((v, k) -> System.out.println(v / k)));*/

        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            key = random.nextInt(10) > 6 ? 0 : 1;
            process(someNumbers, key, wrapperLambda((v, k) -> System.out.println(v / k)));
        }

        List<Integer> integers = Arrays.asList(3, 9, 7, 0, 10, 20);
        integers.forEach(consumerWrapper(i -> System.out.println(50 / i), ArithmeticException.class));
    }

    private static void process(int[] numbers, int key, BiConsumer<Integer, Integer> consumer) {
        for (int i : numbers) {
            consumer.accept(i, key);
        }
    }

    private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer) {
        return (value, key) -> {
            try {
                System.out.println("value = " + value + " key =" + key);
                consumer.accept(value, key);
            } catch (ArithmeticException e) {
                System.out.println("Exception caught in wrapper lambda.");
            }
        };
    }

    private static <T, E extends Exception> Consumer<T> consumerWrapper (Consumer<T> consumer, Class<E> clazz) {
        return i -> {
            try {
                consumer.accept(i);
            } catch (Exception ex) {
                try {
                    E exCast = clazz.cast(ex);
                    System.err.println("Exception occured : " + exCast.getMessage());
                } catch (ClassCastException ccEx) {
                    throw ex;
                }
            }
        };
    }
}
