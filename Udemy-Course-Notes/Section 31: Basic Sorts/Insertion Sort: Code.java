package algorithms.sorts.insertionsort;

import java.util.Arrays;

public class InsertionSort {

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            while (j > -1 && temp < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] myArray = {4, 2, 6, 5, 1, 3};
        insertionSort(myArray);
        System.out.println(Arrays.toString(myArray));

        // EXPECTED OUTPUT:
        // [1, 2, 3, 4, 5, 6]
    }
}
