class Solution {
    public int integerReplacement(int n) {
        if (n == Integer.MAX_VALUE) return 32;
        int operations = 0;  // Initialize the count of operations

        // Loop until n becomes 1
        while (n != 1) {
            if (n % 2 == 0) {
                // If n is even, divide by 2
                n /= 2;
            } else {
                // If n is odd, choose whether to increment or decrement
                if (n == 3 || (n - 1) % 4 == 0) {
                    n--;  // Decrement if n == 3 or n-1 is divisible by 4
                } else {
                    n++;  // Otherwise, increment
                }
            }
            operations++;  // Count each operation
        }

        return operations;
    }
}