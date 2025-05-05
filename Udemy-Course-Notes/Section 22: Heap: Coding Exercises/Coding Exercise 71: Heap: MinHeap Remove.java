import java.util.ArrayList;
import java.util.List;

public class MinHeap {
    private List<Integer> heap;

    public MinHeap() {
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

        while (current > 0 && heap.get(current) < heap.get(parent(current))) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    private void sinkDown(int index) {
        int minIndex = index;
        while (true) {
            int leftIndex = leftChild(index);
            int rightIndex = rightChild(index);

            if (leftIndex < heap.size() && heap.get(leftIndex) < heap.get(minIndex)) {
                minIndex = leftIndex;
            }

            if (rightIndex < heap.size() && heap.get(rightIndex) < heap.get(minIndex)) {
                minIndex = rightIndex;
            }

            if (minIndex != index) {
                swap(index, minIndex);
                index = minIndex;
            } else {
                return;
            }
        }
    }

    // REMOVE METHOD
    public Integer remove() {
        if (heap.size() == 0) {
            return null;  // Return null if the heap is empty
        }

        // If there's only one element, simply remove and return it
        if (heap.size() == 1) {
            return heap.remove(0);
        }

        // Swap the root (smallest) with the last element
        int rootValue = heap.get(0);
        heap.set(0, heap.remove(heap.size() - 1));

        // Perform sink down to restore the min-heap property
        sinkDown(0);

        return rootValue;  // Return the value of the removed root
    }

    public static void main(String[] args) {
        MinHeap myHeap = new MinHeap();
        myHeap.insert(99);
        myHeap.insert(72);
        myHeap.insert(61);
        myHeap.insert(58);
        myHeap.insert(10);
        myHeap.insert(75);

        System.out.println(myHeap.getHeap());  // Print heap after all insertions

        Integer removedValue1 = myHeap.remove();  // Remove the first element (root)
        System.out.println("First Removed Value: " + removedValue1);
        System.out.println(myHeap.getHeap());  // Print heap after first removal

        Integer removedValue2 = myHeap.remove();  // Remove the second element (root)
        System.out.println("Second Removed Value: " + removedValue2);
        System.out.println(myHeap.getHeap());  // Print heap after second removal

        /*
            EXPECTED OUTPUT:
            ----------------
            [10, 58, 72, 99, 61, 75]
            First Removed Value: 10
            [58, 61, 72, 99, 75]
            Second Removed Value: 58
            [61, 75, 72, 99]
        */
    }
}
