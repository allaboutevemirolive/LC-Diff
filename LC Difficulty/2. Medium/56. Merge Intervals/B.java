import java.util.ArrayList;
import java.util.List;

class B {
    public int[][] merge(int[][] intervals) {
        // Find the maximum number in the list of intervals
        int max = 0;
        for (int[] interval : intervals) {
            max = Math.max(max, interval[1]);
        }

        /**
         * Create starts and ends array with size of max+1. Starts array will indicate the starting
         * point of intervals whereas ends array will indicate the end point of intervals. Indices of these arrays
         * will represent the values of the given intervals array.
         */

        int[] starts = new int[max + 1];
        int[] ends = new int[max + 1];

        // Looping over intervals array and assign values to starts and ends array
        for (int[] interval : intervals) {
            starts[interval[0]] += 1;
            ends[interval[1]] += 1;
        }

        // Create an empty 2d array results
        List<int[]> result = new ArrayList<>();

        // Create an empty temp array of size two. This will hold the unique intervals.
        int[] temp = new int[2];

        // This counter will track the opening and closing of a unique interval
        int openCloseCounter = -1;

        // Loop from 0 to max
        for (int i = 0; i <= max; i++) {
            if (starts[i] > 0 && openCloseCounter <= 0) {
                if (openCloseCounter != -1) {
                    result.add(temp);
                }
                temp = new int[2];
                temp[0] = i;
                if (openCloseCounter == -1) openCloseCounter = 0;
            }

            if (ends[i] > 0) {
                temp[1] = i;
            }

            openCloseCounter += starts[i] - ends[i];
        }

        // Add the last interval to the result
        result.add(temp);
        return result.toArray(new int[0][0]);
    }
}