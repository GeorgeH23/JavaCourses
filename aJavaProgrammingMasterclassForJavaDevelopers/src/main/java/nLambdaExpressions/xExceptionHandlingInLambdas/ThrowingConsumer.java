package nLambdaExpressions.xExceptionHandlingInLambdas;

@FunctionalInterface
public interface ThrowingConsumer<T, E extends Exception> {

    public void accept(T t) throws E;
}
