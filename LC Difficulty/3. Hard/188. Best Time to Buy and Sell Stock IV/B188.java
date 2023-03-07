import java.util.Arrays;

class B188 {
    public int maxProfit(int k, int[] prices) {
        // keep track of the maximum profit that can be made after selling a stock
        int[] disposals = new int[k];
        // keep track of the maximum profit that can be made after buying a stock
        int[] acquisitions = new int[k];
        Arrays.fill(acquisitions, Integer.MIN_VALUE);

        for (int value : prices) {
            for (int i = k - 1; i >= 0; i--) {
                // UPDATES the maximum profit that can be made after SELLING a stock on the ith transaction
                disposals[i] = Math.max(disposals[i], acquisitions[i] + value);
                //  CALCULATE the maximum profit that can be made by BUYING a stock on the ith transaction.
                //  if i is 0, it means that we are considering the first transaction,
                //  we set disposal to 0, which means we don't have any profit from the previous transaction.
                //  if i is greater than 0, we can set disposal to the maximum profit we could achieve
                //  from the previous transaction, which has an index of i-1
                int disposal = (i > 0) ? disposals[i - 1] : 0;
                // UPDATES the maximum profit that can be made after BUYING a stock on the ith transaction
                acquisitions[i] = Math.max(acquisitions[i], disposal - value);
            }
        }
        // returns the maximum profit that can be made after completing k transactions,
        // which is stored in the last element of the disposals array.
        // We subtract 1 from k to get the correct index in the disposals array,
        // since the array is 0-indexed.
        return disposals[k - 1];
    }
}