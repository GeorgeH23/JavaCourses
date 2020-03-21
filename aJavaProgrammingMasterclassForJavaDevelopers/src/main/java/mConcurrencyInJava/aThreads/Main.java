package mConcurrencyInJava.aThreads;


import static mConcurrencyInJava.aThreads.ThreadColor.*;

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

        System.out.println(ANSI_PURPLE + "T1 - Hello again from the main Thread.");

        // in order to run the code in anotherThread again we have to create a new instance of AnotherThread class
        anotherThread = new AnotherThread();
        anotherThread.setName("== Another Thread ==");
        anotherThread.start();

        // Thread using Runnable interface
        Thread myRunnableThread = new Thread(new MyRunnable());
        myRunnableThread.start();

        Thread annonymousMyRunnableThread = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println(ANSI_RED + "T5 - Hello from the anonymous class's implementation of run().");
            }
        });
        annonymousMyRunnableThread.start();
    }
}
