import java.util.Arrays;

public class A352 {
    public static void main(String[] args) {
        B352 summaryRanges = new B352();
        summaryRanges.addNum(1);
        int[][] res1 = summaryRanges.getIntervals();
        System.out.println(Arrays.deepToString(res1)); // [[1, 1]]
        summaryRanges.addNum(3);
        int[][] res2 = summaryRanges.getIntervals();
        System.out.println(Arrays.deepToString(res2)); // [[1, 1], [3, 3]]
        summaryRanges.addNum(7);
        int[][] res3 = summaryRanges.getIntervals();
        System.out.println(Arrays.deepToString(res3)); // [[1, 1], [3, 3], [7, 7]]
        summaryRanges.addNum(2);
        int[][] res4 = summaryRanges.getIntervals();
        System.out.println(Arrays.deepToString(res4)); // [[1, 3], [7, 7]]
        summaryRanges.addNum(6);
        int[][] res5 = summaryRanges.getIntervals();
        System.out.println(Arrays.deepToString(res5)); // [[1, 3], [6, 7]]
    }
}
