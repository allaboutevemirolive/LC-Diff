public class A64 {
    public static void main(String[] args) {
        int[][] grid = {{1,3,1}, {1,5,1}, {4,2,1}};
        Solution solution = new Solution();
        int minPathSum = solution.minPathSum(grid);
        System.out.println(minPathSum);
    }
    
}
