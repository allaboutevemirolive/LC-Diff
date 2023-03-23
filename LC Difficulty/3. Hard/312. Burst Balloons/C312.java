class C312 {
    public int solve(int left, int right, int[] nums, int[][] dp) {
        if (left > right) {
            return 0;
        }
        if (dp[left][right] != -1) {
            return dp[left][right];
        }
        int ans = 0;
        for (int mid = left; mid <= right; mid++) {
            int temp = nums[left - 1] * nums[mid] * nums[right + 1] + solve(left, mid - 1, nums, dp)
                    + solve(mid + 1, right, nums, dp);
            ans = Math.max(ans, temp);
        }
        return dp[left][right] = ans;
    }

    public int solveTab(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 2][n + 2];

        for (int left = n - 1; left >= 0; left--) {
            for (int right = left; right < n; right++) {
                if (left > right)
                    continue;
                int previous = left > 0 ? nums[left - 1] : 1;
                int next = right < n - 1 ? nums[right + 1] : 1;
                int max = -1;
                for (int mid = left; mid <= right; mid++) {
                    int coins = previous * next * nums[mid] + dp[left][mid] + dp[mid + 1][right + 1];
                    max = Math.max(max, coins);
                }
                dp[left][right + 1] = max;
            }
        }
        return dp[0][n];
    }

    public int maxCoins(int[] nums) {
        return solveTab(nums);
    }
}