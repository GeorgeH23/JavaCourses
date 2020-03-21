package mConcurrencyInJava.hDeadlocks;

import static mConcurrencyInJava.hDeadlocks.Main.lock1;
import static mConcurrencyInJava.hDeadlocks.Main.lock2;

public class ThreadTwo extends Thread {
    @Override
    public void run() {
        synchronized (lock2) {
            System.out.println("ThreadTwo: Has lock2.");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ThreadTwo: Waiting for lock1.");
            synchronized (lock1) {
                System.out.println("ThreadTwo: Has lock2 and lock1.");
            }
            System.out.println("ThreadTwo: Released lock1.");
        }
        System.out.println("ThreadTwo: Released lock2. Exiting...");
    }
}
