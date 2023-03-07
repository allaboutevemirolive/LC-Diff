import java.util.Arrays;

class B188 {
    public int maxProfit(int k, int[] prices) {
        // keep track of the maximum profit that can be made after selling a stock
        int[] sell = new int[k];
        // keep track of the maximum profit that can be made after buying a stock
        int[] buy = new int[k];

        // If initialize to 0, we might miss out on some possible profits if the actual maximum profit value is negative.
        Arrays.fill(buy, Integer.MIN_VALUE);

        for (int value : prices) {
            for (int i = k - 1; i >= 0; i--) {
                // 'calculate' the maximum profit that can be made by 'buying' the stock on the ith transaction
                int profit = (i > 0) ? sell[i - 1] : 0;
                // 'updates' the maximum profit that can be made after 'buying' the stock on the ith transaction
                buy[i] = Math.max(buy[i], profit - value);
                // 'updates' the maximum profit that can be made after 'selling' a stock on the ith transaction
                sell[i] = Math.max(sell[i], buy[i] + value);
            }
        }
        // we subtract 1 from k to get the correct index in the sell array, since the array is 0-indexed.
        return sell[k - 1];
    }
}