import java.util.*;


public class Main {

public static List<Integer> findDuplicates(int[] nums) {
    HashSet<Integer> seen = new HashSet<>();
    HashSet<Integer> duplicates = new HashSet<>();
    
    for (int num : nums) {
        if (seen.contains(num)) {
            duplicates.add(num);
        } else {
            seen.add(num);
        }
    }
    
    return new ArrayList<>(duplicates);
}

      

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 2, 1, 4, 5, 4};
        List<Integer> duplicates = findDuplicates(nums);
        System.out.println(duplicates); 
        
        /*
            EXPECTED OUTPUT:
            ----------------
			[1, 2, 4]

        */
        
    }

}
