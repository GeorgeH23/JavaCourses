package Algorithms.fMergeSort;

public class MergeSort {

    public static void sort(int[] inputArray) {
        sort(inputArray, 0, inputArray.length-1);
    }

    private static void sort(int[] inputArray, int start, int end) {
        if (end <= start) {
            return; // we're done traversing the array
        }

        int mid = (start + end) / 2;
        sort(inputArray, start, mid); // sort left half
        sort(inputArray, mid+1, end); // sort right half
        merge(inputArray, start, mid, end); // merge sorted results into the inputArray
    }

    private static void merge(int[] inputArray, int start, int mid, int end) {
        int[] tempArray = new int[end - start + 1];

        // index counter for the left side of the array
        int leftSlot = start;
        // index counter for the right side of the array
        int rightSlot = mid+1;
        // tempArray counter
        int count = 0;

        while ((leftSlot <= mid) && (rightSlot <= end)) {
            if (inputArray[leftSlot] < inputArray[rightSlot]) {
                tempArray[count] = inputArray[leftSlot];
                leftSlot++;
            } else {
                tempArray[count] = inputArray[rightSlot];
                rightSlot++;
            }
            count++;
        }

        /**
         * When it gets to here, that means the above loop has completed
         * So bothe the right and the left side of the sub-array can be considered sorted
         */

        if (leftSlot <= mid) { //consider the right side done being sorted. Left side must be sorted already
            while (leftSlot <= mid) {
                tempArray[count] = inputArray[leftSlot];
                leftSlot++;
                count++;
            }
        } else if (rightSlot <= end) { //consider the left side done being sorted. Right side must be sorted already
            while (rightSlot <= end) {
                tempArray[count] = inputArray[rightSlot];
                rightSlot++;
                count++;
            }
        }

        // copy over the tempArray into the appropriate slots of the inputArray
        for (int i = 0; i < tempArray.length; i++) {
            inputArray[start + i] = tempArray[i];
        }
    }
}




















