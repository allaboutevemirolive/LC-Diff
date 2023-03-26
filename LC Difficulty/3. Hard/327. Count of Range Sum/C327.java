import java.util.Arrays;

class C327 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] sums = new long[n + 1];
        for (int i = 0; i < n; ++i) {
            sums[i + 1] = sums[i] + nums[i];
        }
        return countWhileMergeSort(sums, 0, n + 1, lower, upper);
    }

    private int countWhileMergeSort(long[] sums, int start, int end, int lower, int upper) {
        System.out.println("start = " + start + ", end = " + end);
        if (end - start <= 1) {
            System.out.println("return 0;----------- start = " + start + ", end = " + end);
            return 0;
        }
        int mid = (start + end) / 2;
        int nums1 = countWhileMergeSort(sums, start, mid, lower, upper);
        // System.out.println("countWhileMergeSort(sums, " + start + ", " + mid + ", " + lower + ", " + upper + ") = " + nums1);
        int nums2 = countWhileMergeSort(sums, mid, end, lower, upper);
        // System.out.println("countWhileMergeSort(sums, " + mid + ", " + end + ", " + lower + ", " + upper + ") = " + nums2);
        // System.out.println("====================================");
        System.out.println("*********** start = " + start + ", end = " + end + ", mid = " + mid);
        int count = nums1 + nums2;
        int j = mid, k = mid, t = mid;
        long[] cache = new long[end - start];
        for (int i = start, r = 0; i < mid; ++i, ++r) {
            while (k < end && sums[k] - sums[i] < lower) {
                k++;
            }
            while (j < end && sums[j] - sums[i] <= upper) {
                j++;
            }
            while (t < end && sums[t] < sums[i]) {
                cache[r++] = sums[t++];
            }
            cache[r] = sums[i];
            count += j - k;
        }
        System.arraycopy(cache, 0, sums, start, t - start);
        return count;
    }
    
}