package mConcurrencyInJava.bInterruptAndJoin;

import static mConcurrencyInJava.bInterruptAndJoin.ThreadColor.*;

public class AnotherThread extends Thread {

    @Override
    public void run() {
        System.out.println(ANSI_BLUE + "T2 - Hello from " + currentThread().getName() + ".");

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            System.out.println(ANSI_BLUE + "T2 - Another thread woke me up.");
            return;
        }
        System.out.println(ANSI_BLUE + "T2 - Three seconds have passed and I'm awake.");
    }
}
