import java.util.Scanner;

/**
 * Algorithms and Data Structures Assignment: Recursion and Big-O Notation.
 * <p>
 * All task methods use purely recursive algorithms (no loops in task logic).
 * Each method documents Time and Space complexity in Big-O notation.
 */
public class RecursionAssignment {

    /**
     * Task 1: Returns the sum of squares of the first n positive integers:
     * 1² + 2² + ... + n².
     * <p>
     * Time Complexity: O(n) — one recursive call per integer from n down to 1,
     * so the recursion tree is a single chain of n nodes; each node does O(1) work.
     * <p>
     * Space Complexity: O(n) — maximum call-stack depth is n (one frame per
     * recursive call until the base case).
     *
     * @param n number of positive integers to include (n ≥ 0)
     * @return sum of squares 1² + 2² + ... + n²
     */
    public static int sumOfSquares(int n) {
        if (n <= 0) {
            return 0;
        }
        return n * n + sumOfSquares(n - 1);
    }

    /**
     * Task 2: Returns the sum of the first n elements of the given array.
     * <p>
     * Time Complexity: O(n) — one recursive call per element indexed 0..n-1;
     * the recursion tree is a single chain of n nodes with O(1) work each.
     * <p>
     * Space Complexity: O(n) — maximum call-stack depth is n.
     *
     * @param arr the array of integers
     * @param n   number of elements to sum from the start of the array (n ≥ 0)
     * @return sum of arr[0] + arr[1] + ... + arr[n - 1]
     */
    public static int sumOfArray(int[] arr, int n) {
        if (n <= 0) {
            return 0;
        }
        return arr[n - 1] + sumOfArray(arr, n - 1);
    }

    /**
     * Task 3: Returns the sum of the first (n + 1) powers of base b:
     * b⁰ + b¹ + b² + ... + bⁿ.
     * <p>
     * Time Complexity: O(n) — one recursive call for each exponent from n down
     * to 0; each call performs O(1) work (including computing bⁿ), so total
     * work along the single-chain recursion tree is O(n).
     * <p>
     * Space Complexity: O(n) — maximum call-stack depth is n + 1.
     *
     * @param b the base
     * @param n the highest exponent (n ≥ 0)
     * @return sum b⁰ + b¹ + ... + bⁿ
     */
    public static double sumOfPowers(double b, int n) {
        if (n < 0) {
            return 0.0;
        }
        if (n == 0) {
            return 1.0; // b^0 = 1 for any non-zero b (and conventionally for b = 0)
        }
        return Math.pow(b, n) + sumOfPowers(b, n - 1);
    }

    /**
     * Task 4: Reads n elements from the scanner and prints them in reverse order.
     * Uses the call stack to store elements — no arrays, lists, or loops.
     * <p>
     * Strategy: read the next element, recurse for the remaining n − 1 elements,
     * then print the current element on the way back (backtracking). Deeper calls
     * therefore print first, producing the reversed sequence.
     * <p>
     * Time Complexity: O(n) — exactly n recursive calls; each reads one int and
     * later prints it in O(1) time. The recursion tree is a single chain of n nodes.
     * <p>
     * Space Complexity: O(n) — maximum call-stack depth is n; each pending frame
     * holds one unread-or-waiting-to-print value until backtracking completes.
     *
     * @param scanner source of the sequence elements
     * @param n       number of remaining elements to read and reverse-print
     */
    public static void reverseSequence(Scanner scanner, int n) {
        if (n <= 0) {
            return;
        }
        int value = scanner.nextInt();
        reverseSequence(scanner, n - 1);
        // n == 1 is the deepest call and prints first → no leading space before it
        if (n != 1) {
            System.out.print(" ");
        }
        System.out.print(value);
    }

    /**
     * Shared test runner: runs all four recursive tasks with sample inputs
     * and prints clearly formatted results.
     */
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("  Recursion Assignment — Test Results");
        System.out.println("========================================");

        // ----- Task 1: Sum of Squares -----
        System.out.println();
        System.out.println("--- Task 1: Sum of Squares ---");
        int nSquares = 4;
        System.out.println("Input:    n = " + nSquares);
        System.out.println("Output:   " + sumOfSquares(nSquares));
        System.out.println("Expected: 30");
        System.out.println("Check:    1² + 2² + 3² + 4² = 1 + 4 + 9 + 16 = 30");

        // ----- Task 2: Sum of Array Elements -----
        System.out.println();
        System.out.println("--- Task 2: Sum of Array Elements ---");
        int[] arr = {10, 20, 30, 40, 50};
        int nArray = 3;
        System.out.println("Input:    arr = [10, 20, 30, 40, 50], n = " + nArray);
        System.out.println("Output:   " + sumOfArray(arr, nArray));
        System.out.println("Expected: 60");
        System.out.println("Check:    10 + 20 + 30 = 60");
        System.out.println("Base case n = 0 → " + sumOfArray(arr, 0));

        // ----- Task 3: Sum of Powers -----
        System.out.println();
        System.out.println("--- Task 3: Sum of Powers ---");
        double base = 4.0;
        int nPowers = 3;
        System.out.println("Input:    b = " + base + ", n = " + nPowers);
        System.out.println("Output:   " + sumOfPowers(base, nPowers));
        System.out.println("Expected: 85.0");
        System.out.println("Check:    4⁰ + 4¹ + 4² + 4³ = 1 + 4 + 16 + 64 = 85");

        // ----- Task 4: Reverse Sequence -----
        System.out.println();
        System.out.println("--- Task 4: Reverse Sequence ---");
        System.out.println("Input:    N = 3, sequence = 1 2 3");
        System.out.print("Output:   ");
        Scanner sample = new Scanner("3\n1 2 3");
        int nReverse = sample.nextInt();
        reverseSequence(sample, nReverse);
        System.out.println();
        System.out.println("Expected: 3 2 1");
        sample.close();

        System.out.println();
        System.out.println("========================================");
        System.out.println("  All tasks completed.");
        System.out.println("========================================");
    }
}
