import java.util.Arrays;


public class Main {

public static int removeElement(int[] nums, int val) {
    int index = 0;

    for (int i = 0; i < nums.length; i++) {
        if (nums[i] != val) {
            nums[index] = nums[i];
            index++;
        }
    }

    return index;
}





    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int val1 = 1;
        int newLength1 = removeElement(nums1, val1);
        System.out.println("Test case 1: Modified array: " +
                           Arrays.toString(Arrays.copyOfRange(nums1, 0, newLength1)) +
                           "\nNew length: " + newLength1);
                           
        // Test case 2
        int[] nums2 = {1, 2, 3, 4, 5, 6};
        int val2 = 6;
        int newLength2 = removeElement(nums2, val2);
        System.out.println("Test case 2: Modified array: " +
                           Arrays.toString(Arrays.copyOfRange(nums2, 0, newLength2)) +
                           "\nNew length: " + newLength2);
                           
        // Test case 3
        int[] nums3 = {-1, -2, -3, -4, -5};
        int val3 = -1;
        int newLength3 = removeElement(nums3, val3);
        System.out.println("Test case 3: Modified array: " +
                           Arrays.toString(Arrays.copyOfRange(nums3, 0, newLength3)) +
                           "\nNew length: " + newLength3);
    
        // Test case 4
        int[] nums4 = {};
        int val4 = 1;
        int newLength4 = removeElement(nums4, val4);
        System.out.println("Test case 4: Modified array: " +
                           Arrays.toString(Arrays.copyOfRange(nums4, 0, newLength4)) +
                           "\nNew length: " + newLength4);
    
        // Test case 5
        int[] nums5 = {1, 1, 1, 1, 1};
        int val5 = 1;
        int newLength5 = removeElement(nums5, val5);
        System.out.println("Test case 5: Modified array: " +
                           Arrays.toString(Arrays.copyOfRange(nums5, 0, newLength5)) +
                           "\nNew length: " + newLength5);
    }

}


