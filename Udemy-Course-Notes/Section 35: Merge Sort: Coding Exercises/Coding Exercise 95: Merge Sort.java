import java.util.Arrays;


public class Main {

    public static int[] merge(int[] array1, int[] array2) {
        int[] combined = new int[array1.length + array2.length];
        int index = 0;
        int i = 0;
        int j = 0;
        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
                combined[index] = array1[i];
                index++;
                i++;
            } else {
                combined[index] = array2[j];
                index++;
                j++;
            }
        }
        while (i < array1.length) {
            combined[index] = array1[i];
            index++;
            i++;
        }
        while (j < array2.length) {
            combined[index] = array2[j];
            index++;
            j++;
        }
        return combined;
    }


public static int[] mergeSort(int[] array) {
    if (array.length <= 1) {
        return array;
    }

    int middle = array.length / 2;

    int[] left = Arrays.copyOfRange(array, 0, middle);
    int[] right = Arrays.copyOfRange(array, middle, array.length);

    return merge(mergeSort(left), mergeSort(right));
}



    public static void main(String[] args) {

        int[] originalArray = {3,1,4,2};

        int [] sortedArray = mergeSort(originalArray);

        System.out.println( "Original Array: " + Arrays.toString( originalArray ) );

        System.out.println( "\nSorted Array: " + Arrays.toString( sortedArray ) );

        /*
            EXPECTED OUTPUT:
            ----------------
            Original Array: [3, 1, 4, 2]
            
            Sorted Array: [1, 2, 3, 4]

         */

    }

}
