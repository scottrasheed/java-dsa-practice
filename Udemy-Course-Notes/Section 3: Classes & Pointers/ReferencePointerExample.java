package misc.pointers;

import java.util.HashMap;

public class Main {
  
  public static void main(String[] args) {
    
    HashMap<String, Integer> map1 = new HashMap<>();
    HashMap<String, Integer> map2; // Declare map2

    map1.put("value", 11);
    map2 = map1; // Point map2 to the same object as map1

    System.out.println(map1);
    System.out.println(map2);
  }
}
