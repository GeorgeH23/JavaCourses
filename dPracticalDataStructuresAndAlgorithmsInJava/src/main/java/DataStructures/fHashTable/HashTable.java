package DataStructures.fHashTable;

import java.math.BigInteger;
import java.util.Arrays;

public class HashTable {

    private String[] hashArray;
    private int arraySize;
    private int size; // counter for the number of elements in the hash table

    public HashTable(int numberOfSlots) {
        this.size = 0;

        if (isPrime(numberOfSlots)) {
            this.hashArray = new String[numberOfSlots];
            this.arraySize = numberOfSlots;
        } else {
            int primeCount = getNextPrime(numberOfSlots);
            this.hashArray = new String[primeCount];
            this.arraySize = primeCount;
            System.out.println("Hash table size given: " + numberOfSlots + " is not a prime.");
            System.out.println("Hash table size changed to: " + primeCount + ".");
        }
    }

    private boolean isPrime(int number) {
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private int getNextPrime(int number) {
        for (int i = number; true; i++) {
            if (isPrime(i)) {
                return i;
            }
        }
    }

    // return preferred index position
    private int hashFunc1(String word) {
        int hashVal = word.hashCode();
        hashVal = hashVal % arraySize;
        if (hashVal < 0) {
            hashVal += arraySize;
        }
        return hashVal; // ideal index position we'd like to insert or search in
    }

    // return step size (greater than 0)
    private int hashFunc2(String word) {
        int hashVal = word.hashCode();
        hashVal %= arraySize;

        if (hashVal < 0) {
            hashVal += arraySize;
        }

        // it must be a prime number greater then the arraySize(3,7,11...)
        return 3 - hashVal % 3;
    }

    public void insert(String word) {
        int preferredIndex = hashFunc1(word);
        int stepSize = hashFunc2(word);

        while (hashArray[preferredIndex] != null) {
            preferredIndex = preferredIndex + stepSize;
            preferredIndex = preferredIndex % arraySize;
        }

        hashArray[preferredIndex] = word;
        System.out.println("Inserted word: " + word + ".");
        size++;
    }

    public String find(String word) {
        int preferredIndex = hashFunc1(word);
        int stepSize = hashFunc2(word);

        while (hashArray[preferredIndex] != null) {
            if (hashArray[preferredIndex].equals(word)) {
                return hashArray[preferredIndex];
            }
            preferredIndex = preferredIndex + stepSize;
            preferredIndex = preferredIndex % arraySize;
        }

        return hashArray[preferredIndex];
    }

    public void displayTable() {
        System.out.println("Table: ");
        System.out.println(Arrays.toString(hashArray));
    }

}




















