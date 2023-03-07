import java.util.Arrays;

class C188 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (k >= n / 2) {
            int maxProfit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }
        int[] acquisitions = new int[k + 1];
        int[] disposals = new int[k + 1];
        Arrays.fill(acquisitions, Integer.MIN_VALUE);
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                acquisitions[j] = Math.max(acquisitions[j], disposals[j - 1] - prices[i]);
                disposals[j] = Math.max(disposals[j], acquisitions[j] + prices[i]);
            }
        }
        return disposals[k];
    }
}
