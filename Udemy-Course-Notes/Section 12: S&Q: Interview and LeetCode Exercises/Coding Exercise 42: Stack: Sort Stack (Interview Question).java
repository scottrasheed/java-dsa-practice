import java.util.ArrayList;

public class Main {

    // Sort stack method
    public static void sortStack(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();  // Temporary stack to store sorted elements

        while (!stack.isEmpty()) {
            // Pop the top element from the original stack
            int current = stack.pop();

            // While temporary stack is not empty and top element of temp stack is greater than current
            while (!tempStack.isEmpty() && tempStack.peek() > current) {
                // Move elements from temp stack back to original stack
                stack.push(tempStack.pop());
            }

            // Push the current element to the temp stack
            tempStack.push(current);
        }

        // Transfer the elements back to the original stack
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        System.out.println("Before sorting:");
        stack.printStack();

        sortStack(stack);

        System.out.println("\nAfter sorting:");
        stack.printStack();

        /*
            EXPECTED OUTPUT:
            ----------------
            Before sorting:
            4
            2
            1
            3
            
            After sorting:
            1
            2
            3
            4
        */
    }
}

class Stack<T> {

    private ArrayList<T> stackList = new ArrayList<>();  

    public ArrayList<T> getStackList() {
        return stackList;
    }

    public void printStack() {
        for (int i = stackList.size() - 1; i >= 0; i--) {
            System.out.println(stackList.get(i));
        }
    }

    public boolean isEmpty() {
        return stackList.size() == 0;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        } else {
            return stackList.get(stackList.size() - 1);
        }
    }

    public int size() {
        return stackList.size();
    }

    public void push(T value) {
        stackList.add(value);
    }

    public T pop() {
        if (isEmpty()) return null;
        return stackList.remove(stackList.size() - 1);
    }
}
