import java.util.ArrayList;

public class Main {

    // Write the isBalancedParentheses method here
    public static boolean isBalancedParentheses(String str) {
        int balance = 0;  // Keep track of the balance of parentheses

        // Traverse the string
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // If it's an opening parenthesis, increment balance
            if (ch == '(') {
                balance++;
            }
            // If it's a closing parenthesis, decrement balance
            else if (ch == ')') {
                balance--;
            }

            // If at any point balance becomes negative, it's unbalanced
            if (balance < 0) {
                return false;
            }
        }

        // If balance is 0, the parentheses are balanced, otherwise not
        return balance == 0;
    }

    public static void main(String[] args) {
        testAndPrint("()", true);
        testAndPrint("()()", true);
        testAndPrint("(())", true);
        testAndPrint("()()()", true);
        testAndPrint("(()())", true);
        testAndPrint(")()(", false);
        testAndPrint(")(", false);
        testAndPrint("(()", false);
        testAndPrint("))", false);
        testAndPrint("(", false);
        testAndPrint(")", false);
    }
    
    public static void testAndPrint(String testStr, boolean expected) {
        // Run the test and store the result
        boolean result = isBalancedParentheses(testStr);
        
        // Print the test string, expected result, and actual result
        System.out.println("Test String: " + testStr);
        System.out.println("EXPECTED: " + expected);
        System.out.println("RESULT: " + result);
        
        // Check if the test passed or failed
        if (result == expected) {
            System.out.println("STATUS: PASS");
        } else {
            System.out.println("STATUS: FAIL");
        }
        
        // Print a separator for better readability
        System.out.println("--------------");
    }
}

class Stack<T> {
    
    private ArrayList<T> stackList = new ArrayList<>();  
    
    public ArrayList<T> getStackList() {
        return stackList;
    }
    
    public void printStack() {
        for (int i = stackList.size()-1; i >= 0; i--) {
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
