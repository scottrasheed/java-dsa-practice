package algorithms.sorts.mergesort;

import java.util.Arrays;

public class MergeSort {

    public static int[] merge(int[] array1, int[] array2) {
        int[] combined = new int[array1.length + array2.length];
        int i = 0, j = 0, k = 0;

        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
                combined[k++] = array1[i++];
            } else {
                combined[k++] = array2[j++];
            }
        }

        while (i < array1.length) {
            combined[k++] = array1[i++];
        }

        while (j < array2.length) {
            combined[k++] = array2[j++];
        }

        return combined;
    }

    public static void main(String[] args) {
        int[] array1 = {1, 3, 7, 8};
        int[] array2 = {2, 4, 5, 6};

        System.out.println(Arrays.toString(merge(array1, array2)));

        /*
            EXPECTED OUTPUT:
            ----------------
            [1, 2, 3, 4, 5, 6, 7, 8]
         */
    }
}
