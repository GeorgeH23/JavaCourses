package mConcurrencyInJava.zChallenges.aChallenge1and2;

public class Main {

    public static void main(String[] args) {

        final BankAccount account = new BankAccount("12345-678", 1000.00) ;

        /*Thread t1 = new Thread() {
            @Override
            public void run() {
                account.deposit(300);
                account.withdraw(50);
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                account.deposit(203.75);
                account.withdraw(100.00);
            }
        };

        t1.setName("Thread 1");
        t2.setName("Thread 2");

        t1.start();
        t2.start();*/

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
