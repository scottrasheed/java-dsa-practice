import java.util.*;


public class Main {
    
public static Character firstNonRepeatingChar(String str) {
    HashMap<Character, Integer> countMap = new HashMap<>();
    
    for (char c : str.toCharArray()) {
        countMap.put(c, countMap.getOrDefault(c, 0) + 1);
    }
    
    for (char c : str.toCharArray()) {
        if (countMap.get(c) == 1) {
            return c;
        }
    }
    
    return null;
}



    public static void main(String[] args) {
        System.out.println(firstNonRepeatingChar("leetcode"));
        System.out.println(firstNonRepeatingChar("hello"));
        System.out.println(firstNonRepeatingChar("aabbcc"));
        
        /*
            EXPECTED OUTPUT:
            ----------------
            l
            h
            null

        */
        
    }
    
}
