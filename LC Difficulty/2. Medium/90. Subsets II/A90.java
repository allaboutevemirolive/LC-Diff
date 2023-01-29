import java.util.List;

public class A90 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> subsets = B90.subsetsWithDup(nums);
        System.out.println(subsets);
    }
}
