package mConcurrencyInJava.eThreadsSynchronization;

public class CountdownThread extends Thread {

    private CountDown threadCountdown;

    public CountdownThread (CountDown countDown) {
        threadCountdown = countDown;
    }

    public void run() {
        threadCountdown.doCountdown();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadCountdown.doCountdown1();
    }

}
