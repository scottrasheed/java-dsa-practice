mport java.util.ArrayList;

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
    
    public void push(T element) {
        stackList.add(element); // Add the element to the end of the list (top of the stack)
    }
}

public class Main {

    public static void main(String[] args) {
        
        // Specify the type of the Stack (in this case Integer)
        Stack<Integer> myStack = new Stack<>();
        
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        
        myStack.printStack();
        
        /*
            EXPECTED OUTPUT:
            3
            2
            1
        */
    }
}
