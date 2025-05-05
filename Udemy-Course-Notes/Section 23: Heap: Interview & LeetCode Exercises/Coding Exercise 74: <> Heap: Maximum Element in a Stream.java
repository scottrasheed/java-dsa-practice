import java.util.ArrayList;
import java.util.List;

public class Main {

    // StreamMax method
    public static List<Integer> streamMax(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int currentMax = Integer.MIN_VALUE;
        
        // Iterate through the array and track the maximum value so far
        for (int num : nums) {
            currentMax = Math.max(currentMax, num);  // Update the current maximum
            result.add(currentMax);  // Add the current maximum to the result list
        }
        
        return result;  // Return the list of maximum values
    }

    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {1, 5, 2, 9, 3, 6, 8};
        System.out.println("Test case 1:");
        System.out.println("Input: [1, 5, 2, 9, 3, 6, 8]");
        System.out.println("Actual output: " + streamMax(nums1));
        System.out.println();
    
        // Test case 2
        int[] nums2 = {10, 2, 5, 1, 0, 11, 6};
        System.out.println("Test case 2:");
        System.out.println("Input: [10, 2, 5, 1, 0, 11, 6]");
        System.out.println("Actual output: " + streamMax(nums2));
        System.out.println();
    
        // Test case 3
        int[] nums3 = {3, 3, 3, 3, 3};
        System.out.println("Test case 3:");
        System.out.println("Input: [3, 3, 3, 3, 3]");
        System.out.println("Actual output: " + streamMax(nums3));
        System.out.println();

        // Expected Output:
        /*
        Test case 1:
        Input: [1, 5, 2, 9, 3, 6, 8]
        Expected output: [1, 5, 5, 9, 9, 9, 9]
        Actual output: [1, 5, 5, 9, 9, 9, 9]

        Test case 2:
        Input: [10, 2, 5, 1, 0, 11, 6]
        Expected output: [10, 10, 10, 10, 10, 11, 11]
        Actual output: [10, 10, 10, 10, 10, 11, 11]

        Test case 3:
        Input: [3, 3, 3, 3, 3]
        Expected output: [3, 3, 3, 3, 3]
        Actual output: [3, 3, 3, 3, 3]
        */
    }

}

class Heap {
    private List<Integer> heap;

    public Heap() {
        this.heap = new ArrayList<>();
    }

    public List<Integer> getHeap() {
        return new ArrayList<>(heap);
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    public void insert(int value) {
        heap.add(value);
        int current = heap.size() - 1;

        while (current > 0 && heap.get(current) > heap.get(parent(current))) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    private void sinkDown(int index) {
        int maxIndex = index;
        while (true) {
            int leftIndex = leftChild(index);
            int rightIndex = rightChild(index);

            if (leftIndex < heap.size() && heap.get(leftIndex) > heap.get(maxIndex)) {
                maxIndex = leftIndex;
            }

            if (rightIndex < heap.size() && heap.get(rightIndex) > heap.get(maxIndex)) {
                maxIndex = rightIndex;
            }

            if (maxIndex != index) {
                swap(index, maxIndex);
                index = maxIndex;
            } else {
                return;
            }
        }
    }

    public Integer remove() {
        if (heap.size() == 0) {
            return null;
        }

        if (heap.size() == 1) {
            return heap.remove(0);
        }

        int maxValue = heap.get(0);
        heap.set(0, heap.remove(heap.size() - 1));
        sinkDown(0);

        return maxValue;
    }
}
