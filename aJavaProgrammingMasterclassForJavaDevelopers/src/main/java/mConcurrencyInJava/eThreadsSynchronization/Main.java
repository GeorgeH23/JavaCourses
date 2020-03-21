package mConcurrencyInJava.eThreadsSynchronization;

public class Main {

    public static void main(String[] args) {

        CountDown countDown1 = new CountDown();
        //CountDown countDown2 = new CountDown();

        CountdownThread t1 = new CountdownThread(countDown1);
        t1.setName("Thread 1");

        CountdownThread t2 = new CountdownThread(countDown1);
        //CountdownThread t2 = new CountdownThread(countDown2);
        t2.setName("Thread 2");

        t1.start();
        t2.start();
    }
}
