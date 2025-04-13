public class BinarySearch {

    // Binary search function
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // Check if target is at mid
            if (arr[mid] == target) {
                return mid; // Target found
            }
            
            // If target is smaller, ignore the right half
            if (arr[mid] > target) {
                right = mid - 1;
            }
            // If target is larger, ignore the left half
            else {
                left = mid + 1;
            }
        }
        
        // Target not found
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21};
        int target = 13;
        
        int result = binarySearch(arr, target);
        
        if (result == -1) {
            System.out.println("Target not found");
        } else {
            System.out.println("Target found at index: " + result);
        }
        
        // Explanation of how binary search works
        /*
        In this binary search implementation, the problem size is halved at each step,
        which is why the time complexity is O(log n).
        
        The array is sorted, and we repeatedly divide it in half by comparing the middle
        element (mid) to the target. If the target is smaller, we discard the right half;
        if it's larger, we discard the left half.
        
        For example, if the array has 11 elements, it will take 3 steps to find the target
        (since log₂(11) ≈ 3).
        
        This is a direct example of an O(log n) algorithm in action, where the number of
        steps grows logarithmically with the size of the input.
        */
    }
}
