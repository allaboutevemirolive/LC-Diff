public class A74 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        int target = 3;
        B74 b74 = new B74();
        boolean result = b74.searchMatrix(matrix, target);
        System.out.println(result);
    }
}
