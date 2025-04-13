package misc.big_o;

class Main {

    /*
     * This method prints all pairs of (i, j) for n x n iterations,
     * followed by a single loop printing values of k from 0 to n.
     *
     * Time Complexity: O(n^2 + n)
     * - The nested loops (i and j): O(n * n) = O(n^2)
     * - The single loop over k: O(n)
     * - Combined: O(n^2 + n)
     *
     * Big O Simplification:
     * - O(n^2) is the dominant term.
     * - O(n) is the non-dominant term and becomes irrelevant as n grows large.
     * - For example: if n = 100
     *   - O(n^2) → 100 * 100 = 10,000 operations
     *   - O(n)   → 100 operations
     *   - O(n^2 + n) ≈ O(10,000 + 100), but 100 is negligible in comparison
     * - Therefore, the final simplified complexity is O(n^2)
     */
    public static void printItems(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(i + " " + j);
            }
        }

        for (int k = 0; k < n; k++) {
            System.out.println(k);
        }
    }

    public static void main(String[] args) {
        printItems(10);
    }
}
