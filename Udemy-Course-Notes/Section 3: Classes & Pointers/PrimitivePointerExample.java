package misc.pointers;

public class Main {
  
  public static void main(String[] args) {
    
    int num1 = 11;
    int num2 = num1;
    
    num1 = 22;
    
    System.out.println("num1: " + num1);
    System.out.println("num2: " + num2);
  }
  
}
