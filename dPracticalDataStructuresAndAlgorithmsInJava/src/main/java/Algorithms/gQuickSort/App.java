package Algorithms.gQuickSort;

import java.util.Arrays;

public class App {

    private static int callCount = 0;

    public static void main(String[] args) {

        /**
         * QUICK SORT TIME COMPLEXITY: -worst case scenario is O(n^2)
         *                             -best case scenario is Ω(n log(n))
         *                             -average case scenario is θ(n log(n))
         * */

        int[] inputArray = {12, 81, 74, 43, 1098, 0, 8, 92, 17, 754, 912, 0, 6, 4};
        quickSort(inputArray, 0, inputArray.length-1);

        System.out.println(Arrays.toString(inputArray));
        System.out.println("Number of times quickSort() was called: " + callCount);
    }

    private static void quickSort(int[] inputArray, int start, int end) {
        callCount++;
        if (start < end) {
            int partitionPoint = partition(inputArray,start,end); /* index position of the correctly placed
                                                                     pivot value in the array*/
            quickSort(inputArray,start,partitionPoint-1); // sorts the left half of the range
            quickSort(inputArray,partitionPoint+1,end); // sorts the right half of the range
        }

    }

    private static int partition(int[] inputArray, int start, int end) {

        int pivot = inputArray[end];
        int i = start - 1;
        int temp;

        for (int j = start; j <= end-1; j++) {
            if (inputArray[j] <= pivot) {
                i++;
                // swapping inputArray[i] with inputArray[j]
                temp = inputArray[i];
                inputArray[i] = inputArray[j];
                inputArray[j] = temp;
            }
        }

        // put the pivot value in the correct slot
        temp = inputArray[i+1];
        inputArray[i+1] = pivot; // here the pivot is placed in the correct slot of the array
        inputArray[end] = temp;

        return i+1;
    }
}

















