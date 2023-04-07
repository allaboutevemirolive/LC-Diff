import java.util.ArrayList;
import java.util.List;

public class B0039 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        recur(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }

    private static void recur(int[] candidates, int pos, int target, List<Integer> currList, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(currList));
            return;
        }
        if (pos == candidates.length) {
            return;
        }
        if (candidates[pos] <= target) {
            currList.add(candidates[pos]);
            recur(candidates, pos, target - candidates[pos], currList, res);
            currList.remove(currList.size() - 1);
        }
        recur(candidates, pos + 1, target, currList, res);
    }
}
