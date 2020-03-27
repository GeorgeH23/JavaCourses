package Algorithms.fMergeSort;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        int[] inputArray = {9, 7, 3, 1, 6, 3, 2, 6, 8, 9, 2, 3, 0};

        MergeSort.sort(inputArray);

        System.out.println(Arrays.toString(inputArray));
    }
}
