import java.util.Arrays;


public class Main {

    private static void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }


public static int pivot(int[] array, int pivotIndex, int endIndex) {
    int swapIndex = pivotIndex;

    for (int i = pivotIndex + 1; i <= endIndex; i++) {
        if (array[i] < array[pivotIndex]) {
            swapIndex++;
            swap(array, i, swapIndex);
        }
    }

    swap(array, pivotIndex, swapIndex);
    return swapIndex;
}



    public static void main(String[] args) {

        int[] myArray = {4,6,1,7,3,2,5};

        int returnedIndex = pivot(myArray, 0, 6);

        System.out.println( "Returned Index: " + returnedIndex);

        System.out.println( Arrays.toString( myArray ) );

        /*
            EXPECTED OUTPUT:
            ----------------
            Returned Index: 3
            [2, 1, 3, 4, 6, 7, 5]

         */

    }

}
