package mConcurrencyInJava.zChallenges.cChallenge6and7and8and9;

import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {

        final ReentrantLock lock = new ReentrantLock();
        final BankAccount account = new BankAccount("12345-678", 1000.00, lock) ;

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                account.deposit(300);
                account.withdraw(50);
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                account.deposit(203.75);
                account.withdraw(100.00);
            }
        });

        thread1.setName("Thread 1");
        thread2.setName("Thread 2");

        thread1.start();
        thread2.start();

    }
}
