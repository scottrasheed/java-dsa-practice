import java.util.ArrayList;

public class ArrayListExample {

    public static void main(String[] args) {
        // Create an ArrayList to store integers
        ArrayList<Integer> numbers = new ArrayList<>();

        // Add numbers to the ArrayList
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        // Print the ArrayList
        System.out.println("Original ArrayList: " + numbers);

        // Access an element by index (index starts at 0)
        int numberAtIndex1 = numbers.get(1);
        System.out.println("Element at index 1: " + numberAtIndex1);

        // Remove an element by index
        numbers.remove(0);
        System.out.println("After removing index 0: " + numbers);

        // Check if the ArrayList contains a specific value
        boolean contains30 = numbers.contains(30);
        System.out.println("ArrayList contains 30? " + contains30);

        // Get the size of the ArrayList
        int size = numbers.size();
        System.out.println("Size of ArrayList: " + size);
    }
}

/*
    Explanation for ArrayList Example:

    - We created an ArrayList called 'numbers' and added integers using `.add()`.
    - We accessed an element at a specific index with `.get()`.
    - We removed an element using `.remove()` and checked if a value exists with `.contains()`.
    - We used `.size()` to get the size of the ArrayList.

    Time Complexity:
    - Adding: O(1) (amortized time)
    - Accessing by index: O(1)
    - Removing: O(n) (because shifting elements may be required)
    - Searching: O(n) (linear search)
*/
