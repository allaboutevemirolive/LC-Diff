public class A149 {
    public static void main(String[] args) {
        int[][] points = {{1,1}, {2,2}, {3,3}};
        B142 obj = new B142();
        int maxPointsOnLine = obj.maxPoints(points);
        System.out.println("Max points on a line: " + maxPointsOnLine);
    }
}
