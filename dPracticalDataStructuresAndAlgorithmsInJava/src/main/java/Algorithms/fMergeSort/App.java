package Algorithms.fMergeSort;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        /**
         * MERGE SORT TIME COMPLEXITY: -worst case scenario is O(n log(n))
         *                             -best case scenario is Ω(n log(n))
         *                             -average case scenario is θ(n log(n))
         * */

        int[] inputArray = {9, 7, 3, 1, 6, 3, 2, 6, 8, 9, 2, 3, 0};

        MergeSort.sort(inputArray);

        System.out.println(Arrays.toString(inputArray));
    }
}
