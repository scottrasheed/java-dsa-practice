import java.util.HashMap;

public class Main {

public static boolean itemInCommon(int[] array1, int[] array2) {
    HashMap<Integer, Boolean> map = new HashMap<>();
    
    for (int i = 0; i < array1.length; i++) {
        map.put(array1[i], true);
    }
    
    for (int i = 0; i < array2.length; i++) {
        if (map.containsKey(array2[i])) {
            return true;
        }
    }
    
    return false;
}

    

    public static void main(String[] args) {

        int[] array1 = {1, 3, 5};
        int[] array2 = {2, 4, 5};

        System.out.println(itemInCommon(array1, array2));
        
        /*
            EXPECTED OUTPUT:
            ----------------
            true

        */
        
    }

}
