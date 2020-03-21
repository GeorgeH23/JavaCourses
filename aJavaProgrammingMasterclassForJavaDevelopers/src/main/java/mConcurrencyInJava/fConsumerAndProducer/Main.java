package mConcurrencyInJava.fConsumerAndProducer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Message message = new Message();

        (new Thread(new Writer(message))).start();
        (new Thread(new Reader(message))).start();

        // Atomic operations in Java during witch a thread cannot be suspended:
        //      - Reading and writing variable
        //      - Reading and writing primitive variables, except long and double because they require 2 operations

        // Not all methods in Collections class are synchronized. ArrayList is not synchronized, thus is not thread safe
        // which means that if we use an ArrayList in our code which is accessed by multiple threads we are responsible to
        // synchronize that part of the code. Collections.synchronizedList(list);

    }
}

