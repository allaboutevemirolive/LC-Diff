class A123 {
    public static void main(String[] args) {
        B123 obj = new B123();
        int[] prices = { 3, 3, 5, 0, 0, 3, 1, 4 };
        int maxProfit = obj.maxProfit(prices);
        System.out.println("Maximum Profit: " + maxProfit);
    }

}
