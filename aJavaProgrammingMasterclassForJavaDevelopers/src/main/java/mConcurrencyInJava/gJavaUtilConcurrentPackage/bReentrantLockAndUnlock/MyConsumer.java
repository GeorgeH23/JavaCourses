package mConcurrencyInJava.gJavaUtilConcurrentPackage.bReentrantLockAndUnlock;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import static mConcurrencyInJava.gJavaUtilConcurrentPackage.bReentrantLockAndUnlock.Main.EOF;


public class MyConsumer implements Runnable {

    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyConsumer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.bufferLock = bufferLock;
        this.color = color;
    }

    @Override
    public void run() {

        int counter = 0;

        while (true) {

            // First method
            /*bufferLock.lock();

            try {
                if (buffer.isEmpty()) {
                    continue;
                }
                if (buffer.get(0).equals(EOF)) {
                    System.out.println(color + "Exiting...");
                    break;
                } else {
                    System.out.println(color + "Removed " + buffer.remove(0) + ".");
                }
            } finally {
                bufferLock.unlock();
            }*/

            // Second method
            if (bufferLock.tryLock()) {
                try {
                    if (buffer.isEmpty()) {
                        continue;
                    }
                    System.out.println(color + "The counter = " + counter);
                    counter = 0;

                    if (buffer.get(0).equals(EOF)) {
                        System.out.println(color + "Exiting...");
                        break;
                    } else {
                        System.out.println(color + "Removed " + buffer.remove(0) + ".");
                    }
                } finally {
                    bufferLock.unlock();
                }
            } else {
                counter++;
            }

        }
    }
}
