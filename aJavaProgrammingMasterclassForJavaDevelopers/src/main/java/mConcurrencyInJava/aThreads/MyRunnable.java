package mConcurrencyInJava.aThreads;


import static mConcurrencyInJava.aThreads.ThreadColor.*;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(ANSI_RED + "T4 - Hello from MyRunnable's implementation of .run().");
    }
}
