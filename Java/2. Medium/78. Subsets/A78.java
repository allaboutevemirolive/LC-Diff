import java.util.List;

public class A78 {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        List<List<Integer>> result = B78.subsets(nums);
        System.out.println(result);
    }
}