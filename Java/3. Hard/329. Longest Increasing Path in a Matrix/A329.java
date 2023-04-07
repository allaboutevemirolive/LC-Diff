public class A329 {
    public static void main(String[] args) {
        int[][] matrix = { 
            { 9, 9, 4 }, 
            { 6, 6, 8 }, 
            { 2, 1, 1 } 
        };
        B329 obj = new B329();
        int longestPath = obj.longestIncreasingPath(matrix);
        System.out.println("Longest Increasing Path: " + longestPath);
    }
}
