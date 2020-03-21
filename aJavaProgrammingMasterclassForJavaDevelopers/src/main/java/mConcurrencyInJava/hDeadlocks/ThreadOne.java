package mConcurrencyInJava.hDeadlocks;


import static mConcurrencyInJava.hDeadlocks.Main.lock1;
import static mConcurrencyInJava.hDeadlocks.Main.lock2;

public class ThreadOne extends Thread {
    @Override
    public void run() {
        synchronized (lock1) {
            System.out.println("ThreadOne: Has lock1.");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ThreadOne: Waiting for lock2.");
            synchronized (lock2) {
                System.out.println("ThreadOne: Has lock1 and lock2.");
            }
            System.out.println("ThreadOne: Released lock2.");
        }
        System.out.println("ThreadOne: Released lock1. Exiting...");
    }
}
