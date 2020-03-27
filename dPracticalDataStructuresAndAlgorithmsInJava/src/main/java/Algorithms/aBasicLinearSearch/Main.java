package Algorithms.aBasicLinearSearch;

public class Main {

    public static void main(String[] args) {

        int[] arrayA = new int[] {1,2,3,4,65,32,43,423,34,65};
        int[] arrayB = new int[] {23,4,5,75,56,43,8,97,56,45};

        System.out.println(linearSearch(arrayA, 32));
        System.out.println(linearSearch(arrayB,23));
        System.out.println(linearSearch(arrayB,69));
    }

    private static int linearSearch(int[] array, int value) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }

        return -1;
    }
}
