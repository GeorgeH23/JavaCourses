package Algorithms.eInsertionSort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        /**
         * INSERTION SORT TIME COMPLEXITY: -worst case scenario is O(n^2)
         *                                 -best case scenario is Ω(n)
         *                                 -average case scenario is θ(n^2)
         * */

        insertionSort(new int[]{1,65,3,21,69,234,0,6,31,12,9});
    }

    public static int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int element = array[i]; // element variable contains the data we intend on bringing over to the sorted area
            int j = i - 1; // j variable points to the index position of the last value in the sorted area
            while ((j >= 0) && (array[j] > element)) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = element;
        }
        System.out.println(Arrays.toString(array));

        return array;
    }
}
