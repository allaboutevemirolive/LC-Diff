public class A0057 {

    public static void main(String[] args) {
        B0057 b0057 = new B0057();
        int[][] intervals = { { 1, 3 }, { 6, 9 } };
        int[] newInterval = { 2, 5 };
        int[][] mergeIntervals = b0057.insert(intervals, newInterval);

        // Print the merge intervals
        for (int[] interval : intervals) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }
}
