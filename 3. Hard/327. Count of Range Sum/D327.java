import java.util.Arrays;

class D327 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] sums = new long[n + 1];
        for (int i = 0; i < n; ++i) {
            sums[i + 1] = sums[i] + nums[i];
        }
        return countWhileMergeSort(sums, 0, n + 1, lower, upper);
    }

    private int countWhileMergeSort(long[] sums, int start, int end, int lower, int upper) {
        if (end - start <= 1) {
            return 0;
        }
        int mid = (start + end) / 2;
        int count = countWhileMergeSort(sums, start, mid, lower, upper) + countWhileMergeSort(sums, mid, end, lower, upper);
        System.out.println("============================================");
        System.out.println("start = " + start + ", end = " + end + ", mid = " + mid + ", count = " + count);

        int j = mid, k = mid, t = mid;
        System.out.println("j = " + j + ", k = " + k + ", t = " + t);

        long[] cache = new long[end - start];
        System.out.println("cache: \n" + Arrays.toString(cache));

        System.out.println();

        for (int i = start, r = 0; i < mid; ++i, ++r) {
            System.out.println();
            System.out.println("for loop : " + i + " < " + mid);
            System.out.println("i = " + i + ", r = " + r + ", k = " + k + ", j = " + j + ", t = " + t + ", end = " + end);

            System.out.println();
            System.out.println("sums: \n" + Arrays.toString(sums));
            System.out.println("cache: \n" + Arrays.toString(cache));
            System.out.println();

            System.out.println("sums[k]: " + sums[k] + ", sums[i]: " + sums[i] + ", lower: " + lower);
            System.out.println("sums[j]: " + sums[j] + ", sums[i]: " + sums[i] + ", upper: " + upper);
            System.out.println("sums[t]: " + sums[t] + ", sums[i]: " + sums[i]);
            System.out.println();

            while (k < end && sums[k] - sums[i] < lower) {
                System.out.println("while loop 1");
                k++;
                System.out.println();
            }

            while (j < end && sums[j] - sums[i] <= upper) {

                j++;
                System.out.println("while loop 2 : j(update) = " + j);
                System.out.println();
            }

            while (t < end && sums[t] < sums[i]) {
                System.out.println("while loop 3 : t(before) = " + t + ", r(before) = " + r);
                try {
                    System.out.println("cache[r] = " + cache[r] + ", sums[t] = " + sums[t]);
                } catch (Exception e) {
                    System.out.println(e);
                }
                cache[r++] = sums[t++];
                System.out.println("cache(update): \n" + Arrays.toString(cache));
                System.out.println("t(update) = " + t + ", r(update) = " + r);
                System.out.println();
            }
            cache[r] = sums[i];
            System.out.println();
            System.out.println("r = " + r + ", i = " + i);
            System.out.println("cache[r] = sums[i]    :    cache[" + r + "] = " + sums[i]);
            System.out.println("cache(update): \n" + Arrays.toString(cache));
            System.out.println();
            count += j - k;
            System.out.println("j : " + j + ", k : " + k + ", j - k : " + (j - k) + ", count(update) : " + count);
            System.out.println();
        }
        System.out.println("============================================");
        System.out.println("cache(before): \n" + Arrays.toString(cache));
        System.out.println("sums(before) : \n" + Arrays.toString(sums));
        System.out.println();
        System.out.println("start = " + start + ", t = " + t + ", t - start = " + (t - start));
        System.out.println();
        // copy the elements from the 'cache' array to the 'sums' array, starting at index ` and copying a total of 't - start' elements(exclusive).
        System.arraycopy(cache, 0, sums, start, t - start);
        System.out.println("cache(after): \n" + Arrays.toString(cache));
        System.out.println("sums(after) : \n" + Arrays.toString(sums));
        return count;
    }
}