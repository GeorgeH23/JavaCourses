package mConcurrencyInJava.bInterruptAndJoin;

import static mConcurrencyInJava.bInterruptAndJoin.ThreadColor.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(ANSI_PURPLE + "T1 - Hello from the main Thread.");

        Thread anotherThread = new AnotherThread();
        anotherThread.setName("== Another Thread ==");
        // invoking the .start() method enables the JVM to run the .run() method for the anotherThread instance
        anotherThread.start();

        new Thread() {
            @Override
            public void run() {
                System.out.println(ANSI_GREEN + "T3 - Hello from the anonymous class thread.");
            }
        }.start();

        Thread annonymousMyRunnableThread = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println(ANSI_RED + "T4 - Hello from the anonymous class's implementation of run().");
                try {
                    anotherThread.join(2000);
                    System.out.println(ANSI_RED + "T4 - AnotherThread terminated, or timed out, so I'm running again.");
                } catch (InterruptedException e) {
                    System.out.println(ANSI_RED + "T4 - I couldn't wait after all. I was interrupted.");
                }
            }
        });
        annonymousMyRunnableThread.start();

        // Interrupting anotherThread
            // anotherThread.interrupt();

        System.out.println(ANSI_PURPLE + "T1 - Hello again from the main Thread.");
    }
}
