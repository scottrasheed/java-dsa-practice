import java.util.ArrayList;

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
        if (isEmpty()) {
            return null; // If the stack is empty, return null
        } else {
            return stackList.remove(stackList.size() - 1); // Remove and return the last element (top of the stack)
        }
    }
}

public class Main {

    public static void main(String[] args) {
        
        // Specify the type of the Stack (in this case Integer)
        Stack<Integer> myStack = new Stack<>();
        
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        
        System.out.println("Stack before pop():");
        myStack.printStack();
        
        System.out.println("\nPopped node:");
        System.out.println(myStack.pop());
        
        System.out.println("\nStack after pop():");
        myStack.printStack();
 
        /*
            EXPECTED OUTPUT:
            Stack before pop():
            3
            2
            1
            
            Popped node:
            3
            
            Stack after pop():
            2
            1
        */
    }
}
