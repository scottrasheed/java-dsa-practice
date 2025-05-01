import java.util.HashSet;
import java.util.Set;

public class Main {

    public static int longestConsecutiveSequence(int[] nums) {
        // Step 1: Store all unique elements in a set
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longestStreak = 0;

        // Step 2: Iterate through each number
        for (int num : set) {
            // Only start counting if this is the beginning of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Count the length of the consecutive sequence starting from num
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                // Step 3: Update the longest streak found so far
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public static void main(String[] args) {
        testLongestConsecutiveSequence("Consecutive Integers", new int[] {1, 2, 3, 4, 5}, 5);
        testLongestConsecutiveSequence("No Sequence", new int[] {1, 3, 5, 7, 9}, 1);
        testLongestConsecutiveSequence("Duplicates", new int[] {1, 2, 2, 3, 4}, 4);
        testLongestConsecutiveSequence("Negative Numbers", new int[] {1, 0, -1, -2, -3}, 5);
        testLongestConsecutiveSequence("Empty Array", new int[] {}, 0);
        testLongestConsecutiveSequence("Multiple Sequences", new int[] {1, 2, 3, 10, 11, 12, 13}, 4);
        testLongestConsecutiveSequence("Unordered Elements", new int[] {5, 1, 3, 4, 2}, 5);
        testLongestConsecutiveSequence("Single Element", new int[] {1}, 1);
        testLongestConsecutiveSequence("All Identical Elements", new int[] {2, 2, 2, 2, 2}, 1);
    }
    
    /**
     * Test method for longestConsecutiveSequence.
     * @param title Title of the test
     * @param nums Input array
     * @param expected Expected result
     */
    private static void testLongestConsecutiveSequence(String title, int[] nums, int expected) {
        System.out.println("Test: " + title);
        System.out.print("Testing array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    
        int result = longestConsecutiveSequence(nums);
        System.out.println("Expected longest streak: " + expected);
        System.out.println("Actual longest streak: " + result);
    
        if (result == expected) {
            System.out.println("PASS\n");
        } else {
            System.out.println("FAIL\n");
        }
    }
}

/*
EXPECTED OUTPUT:

Test: Consecutive Integers
Testing array: 1 2 3 4 5 
Expected longest streak: 5
Actual longest streak: 5
PASS

Test: No Sequence
Testing array: 1 3 5 7 9 
Expected longest streak: 1
Actual longest streak: 1
PASS

Test: Duplicates
Testing array: 1 2 2 3 4 
Expected longest streak: 4
Actual longest streak: 4
PASS

Test: Negative Numbers
Testing array: 1 0 -1 -2 -3 
Expected longest streak: 5
Actual longest streak: 5
PASS

Test: Empty Array
Testing array:  
Expected longest streak: 0
Actual longest streak: 0
PASS

Test: Multiple Sequences
Testing array: 1 2 3 10 11 12 13 
Expected longest streak: 4
Actual longest streak: 4
PASS

Test: Unordered Elements
Testing array: 5 1 3 4 2 
Expected longest streak: 5
Actual longest streak: 5
PASS

Test: Single Element
Testing array: 1 
Expected longest streak: 1
Actual longest streak: 1
PASS

Test: All Identical Elements
Testing array: 2 2 2 2 2 
Expected longest streak: 1
Actual longest streak: 1
PASS
*/
