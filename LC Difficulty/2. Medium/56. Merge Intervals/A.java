public class A {
    public static void main(String[] args) {
        B0052 b = new B0052();
        int[][] intervals = { { 1, 3 }, { 2, 4 }, { 5, 7 }, { 6, 8 } };
        int[][] result = b.merge(intervals);
        for (int[] interval : result) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }
}
