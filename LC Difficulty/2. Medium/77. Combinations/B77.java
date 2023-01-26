import java.util.ArrayList;
import java.util.List;

class B77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> ds = new ArrayList<>();
        findCombinations(1, n, k, ans, ds);
        return ans;
    }

    private void findCombinations(int index, int n, int target, List<List<Integer>> ans, List<Integer> ds) {

        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = index; i <= n - target + 1; i++) {
            ds.add(i);
            findCombinations(i + 1, n, target - 1, ans, ds);
            ds.remove(ds.size() - 1);
        }
    }
}