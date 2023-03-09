import java.util.List;

public class A218 {
    public static void main(String[] args) {
        B218 obj = new B218();
        int[][] buildings = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        List<List<Integer>> skyline = obj.getSkyline(buildings);
        System.out.println(skyline);
    }
}
