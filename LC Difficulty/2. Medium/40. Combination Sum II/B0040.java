import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B0040 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        recur(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private static void recur(int[] c, int t, int i, List<Integer> currList, List<List<Integer>> res) {
        if (t == 0) {
            res.add(new ArrayList<>(currList));
            return;
        }
        if (i == c.length || t < 0) {
            return;
        }

        for (int j = i; j < c.length; ++j) {
            if (j > i && c[j] == c[j - 1]) {
                continue;
            }
            if (t - c[j] < 0) {
                break;
            }
            currList.add(c[j]);
            recur(c, t - c[j], j + 1, currList, res);
            currList.remove(currList.size() - 1);
        }
    }
}
