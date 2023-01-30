public class C1137 {

    // Recursive
    // Exponential Time Complexity: O(3^N)
    public int tribonacci(int n) {
        if (n == 0 ) return 0;
        if (n == 1 || n == 2) return 1;

        return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
    }
}
