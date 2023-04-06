import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C0018 {

    public List<List<Integer>> s2(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums.length < 4)
            return res;

        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            if (nums[i + 2] + nums[i + 3] > target - nums[i] - nums[i + 1])
                break;
            if (nums[n - 2] + nums[n - 3] < target - nums[i] - nums[n - 1])
                continue;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < n - 2; j++) {
                if (nums[j + 1] + nums[j + 2] > target - nums[i] - nums[j])
                    break;
                if (nums[n - 1] + nums[n - 2] < target - nums[i] - nums[j])
                    continue;
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                long rem = (long) target - nums[i] - nums[j];
                int l = j + 1, r = n - 1;
                while (l < r) {
                    if (nums[l] + nums[r] == rem) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        // Moves through duplicates
                        while (l < r && nums[l] == nums[l + 1])
                            l++;
                        while (l < r && nums[r] == nums[r - 1])
                            r--;
                        l++;
                        r--;
                    } else if (nums[l] + nums[r] < rem)
                        l++;
                    else
                        r--;
                }
            }
        }

        return res;
    }
}
