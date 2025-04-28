import java.util.Stack;

public class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Enqueue method to add an element to the queue
    public void enqueue(int value) {
        // Push the element onto stack1
        stack1.push(value);
    }

    // Peek method to return the front of the queue
    public int peek() {
        if (stack2.isEmpty()) {
            // Transfer all elements from stack1 to stack2 to reverse the order
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        // The top of stack2 is the front of the queue
        return stack2.peek();
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

//-----------------MAIN-------------------------

    public static void main(String[] args) {
        // Create a new queue
        MyQueue q = new MyQueue();

        // Enqueue some values
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        // Output the front of the queue
        System.out.println("Front of the queue: " + q.peek());

        // Check if the queue is empty
        System.out.println("Is the queue empty? " + q.isEmpty());

        /*
            EXPECTED OUTPUT:
            ----------------
            Front of the queue: 1
            Is the queue empty? false
        */
    }
}
