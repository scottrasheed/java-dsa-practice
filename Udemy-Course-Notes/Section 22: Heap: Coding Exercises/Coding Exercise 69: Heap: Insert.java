import java.util.ArrayList;
import java.util.List;

class Main {
    private List<Integer> heap;

    public Main() {
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
        int currentIndex = heap.size() - 1;

        // Heapify up (max-heap)
        while (currentIndex > 0 && heap.get(currentIndex) > heap.get(parent(currentIndex))) {
            swap(currentIndex, parent(currentIndex));
            currentIndex = parent(currentIndex);
        }
    }

    public static void main(String[] args) {
        Main myHeap = new Main();
        myHeap.insert(99);
        myHeap.insert(72);
        myHeap.insert(61);
        myHeap.insert(58);

        System.out.println(myHeap.getHeap());

        myHeap.insert(100);
        System.out.println(myHeap.getHeap());

        myHeap.insert(75);
        System.out.println(myHeap.getHeap());

        /*
            EXPECTED OUTPUT:
            ----------------
            [99, 72, 61, 58]
            [100, 99, 61, 58, 72]
            [100, 99, 75, 58, 72, 61]
        */
    }
}
