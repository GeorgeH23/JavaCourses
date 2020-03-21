package mConcurrencyInJava.aThreads;


import static mConcurrencyInJava.aThreads.ThreadColor.*;

public class AnotherThread extends Thread {

    @Override
    public void run() {
        System.out.println(ANSI_BLUE + "T2 - Hello from " + currentThread().getName() + ".");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(ANSI_BLUE + "Another thread woke me up.");
        }
        System.out.println(ANSI_BLUE + "Three seconds have passed and I'm awake.");
    }
}
