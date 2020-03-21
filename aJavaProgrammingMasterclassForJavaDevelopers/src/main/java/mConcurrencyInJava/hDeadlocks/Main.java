package mConcurrencyInJava.hDeadlocks;

public class Main {

    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();

    public static void main(String[] args) {

        // The solution for this to work and avoid a dead lock is
        // for ThreadOne and ThreadTwo to obtains the locks in the same order.

        new ThreadOne().start();
        new ThreadTwo().start();

    }
}
