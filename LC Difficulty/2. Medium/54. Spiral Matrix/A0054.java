import java.util.List;

public class A0054 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        B0054 b0054 = new B0054();
        List<Integer> result = b0054.spiralOrder(matrix);
        System.out.println(result);
    }
    
}
