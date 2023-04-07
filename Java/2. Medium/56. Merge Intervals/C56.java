import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class C56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][];
        }
        
        // Sort the intervals by their start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        // Initialize a list to store the merged intervals
        List<int[]> mergedIntervals = new LinkedList<>();
        mergedIntervals.add(intervals[0]);
        
        // Iterate through the intervals and check for overlaps
        for (int i = 1; i < intervals.length; i++) {
            int[] currentInterval = intervals[i];
            int[] previousInterval = mergedIntervals.get(mergedIntervals.size() - 1);
            
            // If there is an overlap, merge the intervals
            if (currentInterval[0] <= previousInterval[1]) {
                previousInterval[1] = Math.max(previousInterval[1], currentInterval[1]);
            } else {
                // If there is no overlap, add the current interval to the list
                mergedIntervals.add(currentInterval);
            }
        }
        
        // Convert the list of merged intervals to an array
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}