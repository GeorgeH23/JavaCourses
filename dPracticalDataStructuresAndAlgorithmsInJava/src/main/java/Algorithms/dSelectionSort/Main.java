package Algorithms.dSelectionSort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        selectionSort(new int[]{1,65,3,21,69,234,0,6,31,12,9});
    }

    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minimum = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minimum]) { // if we find a smaller value
                    minimum = j;
                }
            }
            int temp = array[i];
            array[i] = array[minimum];
            array[minimum] = temp;
        }
        System.out.println(Arrays.toString(array));

        return array;
    }
}
