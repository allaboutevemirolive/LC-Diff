class B327 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] sums = new long[n + 1];
        // [-2, 5, -1] (nums) -> [0, -2, 3, 2] (sums)
        for (int i = 0; i < n; ++i) {
            sums[i + 1] = sums[i] + nums[i];
        }
        return countWhileMergeSort(sums, 0, n + 1, lower, upper);
    }

    private int countWhileMergeSort(long[] sums, int start, int end, int lower, int upper) {
        // It's mean that there is not enough elements to be divided.
        if (end - start <= 1) {
            return 0;
        }
        int mid = (start + end) / 2;
        // iterate the left and right part of the array.

        // [0, -2, 3, 2] (sums) -> [0, -2] (left part) and [3, 2] (right part)

        // [0, -2] (left part) -> [-2,0]  start = 0, end = 2, count = 1
        // [3, 2] (right part) -> [2,3]   start = 2, end = 4, count = 1

        // [0, -2, 3, 2] (sums) -> [-2,0,2,3]  start = 0, end = 4, count = 2

        int count = countWhileMergeSort(sums, start, mid, lower, upper) + countWhileMergeSort(sums, mid, end, lower, upper);
        int j = mid, k = mid, t = mid;
        long[] cache = new long[end - start];
        // i, j, k, and t are indices into the sums array, which contains the cumulative sums of the elements in nums
        // r is an index into the cache array, which is used to store the sorted sums array(index t & i)

        // iterate from start to mid
        // for each iteration, we check the difference between current sums (index i) and mid sums
        for (int i = start, r = 0; i < mid; ++i, ++r) {
            // rule 1: check if k(mid) is still less than index end
            // rule 2: check if the difference between mid sums and current sums is out of bound (lower)
            //         we want range sums that lie in [lower, upper] inclusive
            while (k < end && sums[k] - sums[i] < lower) {
                // we increase untill we find cumulative sums that lie in [lower, upper] inclusive
                k++;
            }
            // rule 1: check if j(mid) is still less than index end
            // rule 2: if the differenc between 'mid sums' and 'current sums' is within bound (upper), we increase j
            while (j < end && sums[j] - sums[i] <= upper) {
                // It's mean we have found a range sum that lies within upper bound
                // We increase for each time we have found a range sum that lies within upper bound 
                // untill the new cumulative sums is out of bound (upper)
                j++;
            }
            // rule 1: check if j(mid) is still less than index end
            // rule 2: check if current sums(i) is bigger than mid sums(t)

            // sums: [-2, 0, 3, 2]
            // i = 2, t = 3
            // sums[t]: 2, sums[i]: 3
            // cache: [0,0]  ->  cache: [2,0]
            while (t < end && sums[i] > sums[t] ) {
                // cache: [0,0]  ->  cache: [2,0]
                cache[r++] = sums[t++];
            }
            // cache: [2,0] -> cache: [2,3]
            cache[r] = sums[i];
            count += j - k;
        }
        System.arraycopy(cache, 0, sums, start, t - start);
        return count;
    }
}