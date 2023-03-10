class B220 {

    private class Bucket {
        int value;
        boolean used;
        public Bucket() {}
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        int min = nums[0], max = nums[0];
        for (int i : nums) {
            min = Math.min(i, min);
            max = Math.max(i, max);
        }
        int depth = Math.max(valueDiff, 1);
        int numberOfBuckets = (max - min) / depth + 1;
        Bucket[] buckets = new Bucket[numberOfBuckets];
        int length = nums.length;
        for (int i = 0; i < length; i ++) {
            int index = (nums[i] - min) / depth;

            if (buckets[index] == null) {
                buckets[index] = new Bucket();
            }
            if (buckets[index].used && Math.abs(buckets[index].value - nums[i]) <= valueDiff) {
                return true;
            }
            buckets[index].used = true;
            buckets[index].value = nums[i];

            // check left
            if (index - 1 >= 0 && buckets[index - 1] != null && buckets[index - 1].used && Math.abs(buckets[index - 1].value - nums[i]) <= valueDiff) {
                return true;
            }
            // check right
            if (index + 1 < numberOfBuckets && buckets[index + 1] != null && buckets[index + 1].used && Math.abs(buckets[index + 1].value - nums[i]) <= valueDiff) {
                return true;
            }

            if (i >= indexDiff) {
                int leftMostIndex = (nums[i - indexDiff] - min) / depth;
                buckets[leftMostIndex].used = false;
            }
        }

        return false;
    }
}