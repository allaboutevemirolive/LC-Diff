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
                // We calculate pure profit from our previous sell
                // When i = 0, the code calculates the maximum profit for the first transaction based on the current buy value only. 
                // This is because there are no previous transactions to consider.
                int profit = (i > 0) ? sell[i - 1] : 0;
                // Calculate maximum profit if we buy stock (either zero or negative sales)
                buy[i] = Math.max(buy[i], profit - value);
                // Calculate maximum profit if we sell stock (either zero or positive sales)
                // Only calculate if current value is bigger than previous value
                sell[i] = Math.max(sell[i], buy[i] + value);
            }
        }
        // we subtract 1 from k to get the correct index in the sell array, since the array is 0-indexed.
        return sell[k - 1];
    }
}