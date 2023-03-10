import java.util.HashMap;
import java.util.Map;

class C220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (indexDiff < 1 || valueDiff < 0) {
            return false;
        }
        Map<Long,Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Long remapped = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remapped / ((long)valueDiff + 1);
            if (map.containsKey(bucket) || (map.containsKey(bucket - 1) && Math.abs(map.get(bucket - 1) - remapped) <= valueDiff ) || (map.containsKey(bucket + 1) && Math.abs(map.get(bucket + 1) - remapped) <= valueDiff) ) {
                return true;
            }
            if (i >= indexDiff) {
                map.remove(((long)nums[i - indexDiff] - Integer.MIN_VALUE) / ((long)valueDiff + 1));
            }
            map.put(bucket, remapped);
        }
        return false;
    }
}