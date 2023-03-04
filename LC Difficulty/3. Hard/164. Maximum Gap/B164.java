import java.util.Arrays;

public class B164 {
    public int maximumGap(int[] nums) {
        // Check if the input array is empty or has only one element
        if (nums.length <= 1) {
            return 0;
        }

        // Find the minimum and maximum values in the input array
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        // If all elements in the input array are the same, the maximum gap is 0
        if (min == max) {
            return 0;
        }

        // Calculate the bucket size and the number of buckets
        int bucketSize = (int) Math.ceil((double) (max - min) / (nums.length - 1));
        int numberOfBuckets = (max - min) / bucketSize + 1;

        // Create arrays to store the minimum and maximum values in each bucket
        int[] minBuckets = new int[numberOfBuckets];
        int[] maxBuckets = new int[numberOfBuckets];

        // Initialize the arrays to the largest and smallest possible integer values, respectively
        Arrays.fill(minBuckets, Integer.MAX_VALUE);
        Arrays.fill(maxBuckets, Integer.MIN_VALUE);

        // Assign each element to the appropriate bucket based on its value,
        // and update the maximum and minimum values in each bucket as you go
        for (int i = 0; i < nums.length; i++) {
            int bucketIndex = (nums[i] - min) / bucketSize;
            minBuckets[bucketIndex] = Math.min(minBuckets[bucketIndex], nums[i]);
            maxBuckets[bucketIndex] = Math.max(maxBuckets[bucketIndex], nums[i]);
        }

        // Find the maximum gap between two successive elements by scanning the minBuckets
        // and maxBuckets arrays, and update the maximum gap if necessary
        int gap = 0;
        int previousMax = min;
        for (int i = 0; i < minBuckets.length; i++) {
            if (minBuckets[i] == Integer.MAX_VALUE) {
                // Skip empty buckets
                continue;
            }
            gap = Math.max(gap, minBuckets[i] - previousMax);
            previousMax = maxBuckets[i];
        }

        // Return the maximum gap
        return gap;
    }
}
