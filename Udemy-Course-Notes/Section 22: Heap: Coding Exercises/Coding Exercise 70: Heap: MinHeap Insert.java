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
        heap.add(value);  // Add the new value at the end of the heap
        int current = heap.size() - 1;  // Set the current index to the last index

        // Bubble up to maintain min-heap property
        while (current > 0 && heap.get(current) < heap.get(parent(current))) {
            swap(current, parent(current));  // Swap with parent if current value is smaller
            current = parent(current);  // Move up to the parent index
        }
    }

    public static void main(String[] args) {

        MinHeap myHeap = new MinHeap();
        myHeap.insert(99);
        myHeap.insert(72);
        myHeap.insert(61);
        myHeap.insert(58);

        System.out.println(myHeap.getHeap());  // Prints: [58, 61, 72, 99]

        myHeap.insert(10);

        System.out.println(myHeap.getHeap());  // Prints: [10, 58, 72, 99, 61]

        myHeap.insert(75);

        System.out.println(myHeap.getHeap());  // Prints: [10, 58, 72, 99, 61, 75]

        /*
            EXPECTED OUTPUT:
            ----------------
            [58, 61, 72, 99]
            [10, 58, 72, 99, 61]
            [10, 58, 72, 99, 61, 75]
        */
    }
}
