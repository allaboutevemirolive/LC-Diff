public class A787 {
    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src = 0;
        int dst = 3;
        int k = 1;
        B787 b787 = new B787();
        int result = b787.findCheapestPrice(n, flights, src, dst, k);
        System.out.println("The cheapest price is: " + result);
    }
    
}
