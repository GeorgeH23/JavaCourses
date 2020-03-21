package mConcurrencyInJava.dMultipleThreads;

public class CountdownThread extends Thread {

    private CountDown threadCountdown;

    public CountdownThread (CountDown countDown) {
        threadCountdown = countDown;
    }

    public void run() {
        threadCountdown.doCountdown();
    }

}
