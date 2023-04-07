public class A135 {
    public static void main(String[] args) {
        int[] ratings = {1, 0, 2};
        B135 obj = new B135();
        int minCandies = obj.candy(ratings);
        System.out.println("Minimum number of candies required: " + minCandies);
    }
}
