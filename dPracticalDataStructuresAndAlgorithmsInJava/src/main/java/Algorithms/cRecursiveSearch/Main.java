package Algorithms.cRecursiveSearch;

public class Main {

    public static void main(String[] args) {

        int[] arrayA = new int[] {1,2,3,4,65,32,43,423,34,65};
        int[] arrayB = new int[] {23,4,5,75,56,43,8,97,56,45};

        System.out.println(recursiveLinearSearch(arrayA, 0, 32));
        System.out.println(recursiveLinearSearch(arrayA, 0,65));
        System.out.println(recursiveLinearSearch(arrayB, 0,69));

        arrayA = new int[] {1,2,3,4,5,6,7,8,9};
        arrayB = new int[1_000_000_000];
        for (int i = 0; i < arrayB.length; i++) {
            arrayB[i] = i+1;
        }

        System.out.println(recursiveBinarySearch(arrayA, 0,arrayA.length-1,9));
        System.out.println(recursiveBinarySearch(arrayB,0, arrayB.length-1, 50_387));
    }

    private static int recursiveLinearSearch(int[] array, int index, int value) {

        if (index > array.length-1) { // if true, the value wasn't fount in the array
            return -1;
        } else if (array[index] == value) { // if true, the value was fount in the array at index position
            return index;
        } else {
            return recursiveLinearSearch(array,index + 1,value);
        }
    }

    public static int recursiveBinarySearch(int[] array, int front, int rear, int value) {

        if (front > rear){
            return -1;
        } else {
            int middle = (front + rear) / 2;
            if (array[middle] == value) {
                return middle;
            } else if (array[middle] > value) {
                return recursiveBinarySearch(array,front,middle-1,value);
            } else {
                return recursiveBinarySearch(array,middle+1,rear,value);
            }
        }
    }
}
