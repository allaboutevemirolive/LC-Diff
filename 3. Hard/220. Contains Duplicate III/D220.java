import java.util.HashMap;
import java.util.Map;

public class D220 {
    // Get the ID of the bucket from inputI and bucketWidth
    // In Java, `-3 / 5 = 0` and but we need `-3 / 5 = -1`.
    private long getID(long inputI, long bucketWidth) {
        return inputI < 0 ? (inputI + 1) / bucketWidth - 1 : inputI / bucketWidth;
    }
    public boolean containsNearbyAlmostDuplicate(int[] Input, int indexDiff, int valueDiff ) {
        // If valueDiff is negative, we can't find such pair of indices, so return false
        if (valueDiff  < 0) return false;
        // Create a map to store the buckets
        Map<Long, Long> buckets = new HashMap<>();
        // Calculate the bucket width
        long bucketWidth = (long)valueDiff  + 1;
        for (int i = 0; i < Input.length; ++i) {
            long bucketID = getID(Input[i], bucketWidth);
            // If there is already a number in the same bucket, return true
            // abs(i - j) <= indexDiff
            if (buckets.containsKey(bucketID)) return true;
            // 1. check if there is a number in the adjacent bucket (bucketID-1 or bucketID+1) and
            // 2. the absolute difference between the two numbers is less than or equal to valueDiff
            // abs(nums[i] - nums[j]) <= valueDiff
            if (buckets.containsKey(bucketID - 1) && Math.abs(Input[i] - buckets.get(bucketID - 1)) < bucketWidth) return true;
            if (buckets.containsKey(bucketID + 1) && Math.abs(Input[i] - buckets.get(bucketID + 1)) < bucketWidth) return true;
            buckets.put(bucketID, (long)Input[i]);
            // If the number of elements in the map exceeds indexDiff, remove the oldest element
            if (i >= indexDiff) buckets.remove(getID(Input[i - indexDiff], bucketWidth));
        }
        // If no such pair of indices exists, return false
        return false;
    }
}