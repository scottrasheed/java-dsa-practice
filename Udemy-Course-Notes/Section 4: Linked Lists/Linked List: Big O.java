/*
 * This class implements a custom generic
 * singly linked list in Java.
 *
 * The following operations are implemented:
 *
 * 1. append       - Adds an element to the end of the list.
 *    Big-O: O(1) because we maintain a tail pointer.
 *
 * 2. removeLast   - Removes the last element in the list.
 *    Big-O: O(n) since it traverses the list to find
 *    the second-last node.
 *
 * 3. prepend      - Adds an element to the beginning of the list.
 *    Big-O: O(1)
 *
 * 4. removeFirst  - Removes the first element from the list.
 *    Big-O: O(1)
 *
 * 5. insert       - Inserts an element at a given index.
 *    Big-O: O(n) as it may require traversal.
 *
 * 6. remove       - Removes an element at a specified index.
 *    Big-O: O(n)
 *
 * 7. lookupByIndex- Retrieves an element at a given index.
 *    Big-O: O(n)
 *
 * 8. lookupByValue- Searches for an element by value and
 *    returns its index (or -1 if not found).
 *    Big-O: O(n)
 *
 * Additional utility:
 * - printList: Outputs the list content.
 *
 *****************************
 */

public class MyLinkedList<T> {
    
    // Internal Node class representing each element in the Linked List.
    private static class Node<T> {
        T data;
        Node<T> next;
        
        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node<T> head;
    private Node<T> tail;
    private int size;
    
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    
    /**
     * Append: Adds a new node at the end of the list.
     * Time Complexity: O(1)
     */
    public void append(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    
    /**
     * Prepend: Adds a new node at the beginning of the list.
     * Time Complexity: O(1)
     */
    public void prepend(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }
    
    /**
     * removeLast: Removes the last node from the list.
     * Time Complexity: O(n)
     */
    public T removeLast() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }
        
        // If there's only one element.
        if (head == tail) {
            T data = head.data;
            head = null;
            tail = null;
            size--;
            return data;
        }
        
        // Traverse the list to find the second-to-last element.
        Node<T> current = head;
        while (current.next != tail) {
            current = current.next;
        }
        T data = tail.data;
        tail = current;
        tail.next = null;
        size--;
        return data;
    }
    
    /**
     * removeFirst: Removes the first node from the list.
     * Time Complexity: O(1)
     */
    public T removeFirst() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }
        T data = head.data;
        head = head.next;
        if (head == null) { // List has become empty.
            tail = null;
        }
        size--;
        return data;
    }
    
    /**
     * insert: Inserts a new node at the specified index.
     * Time Complexity: O(n)
     */
    public void insert(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        
        if (index == 0) {
            prepend(data);
            return;
        }
        if (index == size) {
            append(data);
            return;
        }
        
        Node<T> newNode = new Node<>(data);
        Node<T> current = head;
        // Traverse to the node just before the insertion point.
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }
    
    /**
     * remove: Removes the node at the specified index.
     * Time Complexity: O(n)
     */
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        
        if (index == 0) {
            return removeFirst();
        }
        if (index == size - 1) {
            return removeLast();
        }
        
        Node<T> current = head;
        // Traverse to the node just before the one we want to remove.
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        T data = current.next.data;
        current.next = current.next.next;
        size--;
        return data;
    }
    
    /**
     * lookupByIndex: Retrieves the data at a given index.
     * Time Complexity: O(n)
     */
    public T lookupByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
    
    /**
     * lookupByValue: Searches for a node by its value and
     * returns the index. Returns -1 if not found.
     * Time Complexity: O(n)
     */
    public int lookupByValue(T value) {
        Node<T> current = head;
        int index = 0;
        while (current != null) {
            if ((value == null && current.data == null) ||
                (value != null && value.equals(current.data))) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1; // Not found.
    }
    
    /**
     * printList: Utility method to print the contents of the list.
     */
    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
    
    /**
     * size: Returns the number of elements in the list.
     */
    public int size() {
        return size;
    }
    
    /**
     * Main method to demonstrate linked list operations.
     */
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        
        // Append: O(1)
        list.append(10);
        list.append(20);
        list.append(30);
        System.out.print("After appending: ");
        list.printList(); // 10 -> 20 -> 30
        
        // Prepend: O(1)
        list.prepend(5);
        System.out.print("After prepending: ");
        list.printList(); // 5 -> 10 -> 20 -> 30
        
        // Insert at index 2: O(n)
        list.insert(2, 15);
        System.out.print("After inserting 15 at index 2: ");
        list.printList(); // 5 -> 10 -> 15 -> 20 -> 30
        
        // Lookup by index: O(n)
        System.out.println("Element at index 3: " + list.lookupByIndex(3)); // 20
        
        // Lookup by value: O(n)
        System.out.println("Index of value 15: " + list.lookupByValue(15)); // 2
        
        // Remove element at index 2: O(n)
        list.remove(2);
        System.out.print("After removing element at index 2: ");
        list.printList(); // 5 -> 10 -> 20 -> 30
        
        // Remove first: O(1)
        list.removeFirst();
        System.out.print("After removing first element: ");
        list.printList(); // 10 -> 20 -> 30
        
        // Remove last: O(n)
        list.removeLast();
        System.out.print("After removing last element: ");
        list.printList(); // 10 -> 20
        
        System.out.println("Current size: " + list.size());
    }
}
