import java.util.ArrayList;
import java.util.List;

class C90 {
    // res will store all the subsets
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // add an empty subset
        res.add(new ArrayList<>());
        // create an array to store the occurance of each number
        int[] occurancies = new int[21];
        for (int num : nums) {
            // store the occurance of each number
            occurancies[num + 10]++;
        }
        // curr will store the current subset
        List<Integer> curr = new ArrayList<>();
        // call the backtrack function
        backtrack(occurancies, 0, curr);
        return res;
    }

    private void backtrack(int[] occurancies, int idx, List<Integer> curr) {
        // if we have reached the end of occurances array, return
        if (idx == occurancies.length) {
            return;
        }
        // loop through the occurances of current number
        for (int i = 1; i <= occurancies[idx]; ++i) {
            // copy the current subset
            List<Integer> copy = new ArrayList<>(curr);
            // add the current number i times
            for (int j = 0; j < i; ++j) {
                copy.add(idx - 10);
            }
            // add the new subset to the result
            res.add(copy);
            // call the backtrack function with the new subset
            backtrack(occurancies, idx + 1, copy);
        }
        // call the backtrack function with the current subset
        backtrack(occurancies, idx + 1, curr);
    }
}
