class C78 {
    int count = 0;

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> val = new ArrayList<>();
        subsets(nums, 0, val, res);
        return res;
    }

    public void subsets(int[] nums, int level, List<Integer> val, List<List<Integer>> res) {
        if (level == nums.length) {
            res.add(new ArrayList(val));
            return;
        }
        val.add(nums[level]);

        subsets(nums, level + 1, val, res);
        val.remove(val.size() - 1);
        subsets(nums, level + 1, val, res);
    }
}