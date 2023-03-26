
class B321 {
    public int[] maxNumber(int[] nums1, int[] nums2, int ansLen) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] ans = new int[ansLen];

        for (int i = Math.max(0, ansLen - len2); i <= ansLen && i <= len1; ++i) {
            int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, ansLen - i), ansLen);
            if (greater(candidate, 0, ans, 0)) {
                ans = candidate;
            } 
        }
        return ans;
    }

    private int[] merge(int[] nums1, int[] nums2, int ansLen) {
        int[] ans = new int[ansLen];
        for (int i = 0, j = 0, r = 0; r < ansLen; ++r) {
            ans[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        }
        return ans;
    }

    public boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }

    public int[] maxArray(int[] nums, int ansLen) {
        int len3 = nums.length;
        int[] ans = new int[ansLen];
        for (int i = 0, j = 0; i < len3; ++i) {
            // Rule 1 (len3 - i + j > ansLen) : 
            //      Remaining elements that we need to iterate in nums is greater than bucket that we need to fill
            // Rule 2 (j > 0) : 
            //      we already add element into 'ans array' with index j
            // Rule 3 (ans[j - 1] < nums[i]) : 
            //      current element in nums is greater than last element added in ans
            // Then, we can remove last element added in ans
            while (len3 - i + j > ansLen && j > 0 && ans[j - 1] < nums[i]) {
                j--;
            }
            // We can add current element (index i) in nums to ans (index j)
            if (j < ansLen) {
                ans[j++] = nums[i];
            }
        }
        return ans;
    }
}