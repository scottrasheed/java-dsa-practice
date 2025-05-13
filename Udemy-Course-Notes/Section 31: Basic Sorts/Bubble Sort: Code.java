import java.util.Arrays;

public class BubbleSort {

    // Bubble sort algorithm
    public static void bubbleSort(int[] array) {
        boolean swapped;
        for (int i = 0; i < array.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    // swap elements
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {

        int[] myArray = {4, 2, 6, 5, 1, 3};

        bubbleSort(myArray);

        System.out.println(Arrays.toString(myArray));

        /*
            EXPECTED OUTPUT:
            ----------------
            [1, 2, 3, 4, 5, 6]
         */
    }
}
