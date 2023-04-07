public class A63 {
    public static void main(String[] agrs) {
        int[][] obstacleGrid = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
        B63 b = new B63();
        int result = b.uniquePathsWithObstacles(obstacleGrid);
        System.out.println(result);
    }
}
