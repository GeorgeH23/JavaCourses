package mConcurrencyInJava.eThreadsSynchronization;

import static mConcurrencyInJava.eThreadsSynchronization.ThreadColor.*;

public class CountDown {

    private int i;

    // FIRST METHOD TO SYNCHRONIZE

    // By adding the synchronized key word in the method signature we make sure that the entire method
    // is getting executed by one thread before the other thread starts executing it.
    public synchronized void doCountdown() {
        String color;

        switch (Thread.currentThread().getName()) {
            case "Thread 1":
                color = ThreadColor.ANSI_CYAN;
                break;
            case "Thread 2":
                color = ThreadColor.ANSI_PURPLE;
                break;
            default:
                color = ANSI_GREEN;
        }

        for (i = 10; i > 0; i--) {
            System.out.println(color + Thread.currentThread().getName() + " : i = " + i);
        }
        System.out.println(ANSI_GREEN + "****************************************");
    }

        // SECOND METHOD TO SYNCHRONIZE
        // We have to use a global variable (only String variable can be local var) based on which to synchronize the block of code

        public void doCountdown1() {
            String color1;

            switch (Thread.currentThread().getName()) {
                case "Thread 1":
                    color1 = ThreadColor.ANSI_CYAN;
                    break;
                case "Thread 2":
                    color1 = ThreadColor.ANSI_PURPLE;
                    break;
                default:
                    color1 = ANSI_GREEN;
            }

            synchronized (this) {
                for (i = 10; i > 0; i--) {
                    System.out.println(color1 + Thread.currentThread().getName() + " : i = " + i);
                }
            }
            System.out.println(ANSI_BLUE + "****************************************");
    }
}
