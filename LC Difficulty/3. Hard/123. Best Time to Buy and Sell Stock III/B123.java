class B123 {
    public int maxProfit(int[] prices) {
        // initialize variables for the lowest buy prices and the maximum profit
        int buy1 = Integer.MAX_VALUE;
        int buy2 = Integer.MAX_VALUE;
        int sell1 = 0;
        int sell2 = 0;

        // iterate over each price in the prices array
        for (int price : prices) {
            // update the lowest buy price for the first transaction
            buy1 = Math.min(buy1, price);

            // update the maximum profit after the first transaction
            sell1 = Math.max(sell1, price - buy1);

            // update the lowest buy price for the second transaction
            buy2 = Math.min(buy2, price - sell1);

            // update the maximum profit after the second transaction
            sell2 = Math.max(sell2, price - buy2);
        }

        // return the maximum profit after the second transaction
        return sell2;
    }
}
