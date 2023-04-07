import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class C0047 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> permutations = new HashSet<>();
        boolean[] used = new boolean[nums.length];
        permuteUnique(nums, used, new ArrayList<>(), permutations);
        return new ArrayList<>(permutations);
    }

    private void permuteUnique(int[] nums, boolean[] used, List<Integer> permutation, Set<List<Integer>> permutations) {
        if (permutation.size() == nums.length) {
            permutations.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                permutation.add(nums[i]);
                permuteUnique(nums, used, permutation, permutations);
                used[i] = false;
                permutation.remove(permutation.size() - 1);
            }
        }
    }
}
