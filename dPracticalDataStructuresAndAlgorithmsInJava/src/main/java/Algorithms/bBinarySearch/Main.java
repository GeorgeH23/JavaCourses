package Algorithms.bBinarySearch;

public class Main {

    public static void main(String[] args) {

        int[] arrayA = new int[] {1,2,3,4,5,6,7,8,9};
        int[] arrayB = new int[1_000_000_000];
        for (int i = 0; i < arrayB.length; i++) {
            arrayB[i] = i+1;
        }

        System.out.println(binarySearch(arrayA,3));
        System.out.println(binarySearch(arrayB,1_000_000_000));


    }

    public static int binarySearch(int[] array, int value) {
        int front = 0;
        int rear = array.length - 1;
        int middle;

        if (array[front] == value){
            return front;
        }

        if (array[rear] == value) {
            return rear;
        }

        while (front <= rear) {
            middle = (front + rear) / 2;

            if (array[middle] == value) {
                return middle;
            }
            if (array[middle] > value) {
                rear = middle - 1;
            } else {
                front = middle + 1;
            }
        }

        return -1;
    }

}
