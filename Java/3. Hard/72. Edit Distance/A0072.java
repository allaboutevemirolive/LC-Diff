public class A0072 {
    public static void main(String[] args) {
        B0072 solution = new B0072();
        String word1 = "horse";
        String word2 = "ros";
        int result = solution.minDistance(word1, word2);
        System.out.println("Minimum number of operations required to convert " + word1 + " to " + word2 + ": " + result);
    }
}
