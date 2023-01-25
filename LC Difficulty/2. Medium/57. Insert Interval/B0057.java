import java.util.ArrayList;
import java.util.List;

class B0057 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // Initialize an empty list to store the merged intervals
        List<int[]> inter = new ArrayList<>();

        // Iterate through the input intervals
        for(int[] curr : intervals) {
            // If the current interval starts after the new interval ends, add the new interval to the list and set it as the current interval
            if(curr[0] > newInterval[1]) {
                inter.add(newInterval);
                newInterval = curr;
            }
            // If the current interval ends before the new interval starts, add the current interval to the list
            else if(curr[1] < newInterval[0]) {
                inter.add(curr);
            }
            // If the current interval overlaps with the new interval, merge the intervals and update the new interval
            else {
                int st = Math.min(curr[0], newInterval[0]);
                int end = Math.max(curr[1], newInterval[1]);
                newInterval[0] = st;
                newInterval[1] = end;
            }
        }
        // Add the last new interval to the list
        inter.add(newInterval);

        // Convert the list of intervals to a 2D array
        int[][] retu = new int[inter.size()][];
        for(int i=0; i<inter.size(); i++) {
            retu[i] = inter.get(i);
        }

        return retu;
    }
}
