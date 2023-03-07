public class A188 {
    public static void main(String[] args) {
        int k = 2;
        int[] prices = {3, 2, 6, 5, 0, 3};

        B188 obj = new B188();
        int maxProfit = obj.maxProfit(k, prices);

        System.out.println("Maximum profit: " + maxProfit);
    }
}
