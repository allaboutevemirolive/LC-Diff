
class B321 {
    public int[] maxNumber(int[] nums1, int[] nums2, int ansLen) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] ans = new int[ansLen];

        for (int i = Math.max(0, ansLen - len2); i <= ansLen && i <= len1; ++i) {
            int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, ansLen - i), ansLen);
            
            // candidate  : [9, 2, 5, 8, 3]
            // ans(before): [0, 0, 0, 0, 0]
            // TRUE : isGreater
            // ans(after) : [9, 2, 5, 8, 3]
            
            // Check if candidate is greater than ans
            if (greater(candidate, 0, ans, 0)) {
                // If true then assign candidate to ans
                ans = candidate;
            }
        }
        return ans;
    }

    // nums1  : [6]
    // nums2  : [9, 5, 8, 3]
    // ansLen : 5

    // return : [9, 6, 5, 8, 3]
    private int[] merge(int[] nums1, int[] nums2, int ansLen) {
        int[] ans = new int[ansLen];
        // 'r' will use to iterate 'ans' array
        // 'i' will use to iterate 'nums1' array
        // 'j' will use to iterate 'nums2' array
        for (int i = 0, j = 0, r = 0; r < ansLen; ++r) {
            // If current element in nums1 is greater than current element in nums2
            // then add current element in nums1(index i) to ans(index r)
            // else add current element in nums2(index j) to ans(index r)
            ans[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        }
        return ans;
    }

    public boolean greater(int[] nums1, int i, int[] nums2, int j) {
        // Rule 1 (i < nums1.length) :
        //      i is less than nums1.length
        // Rule 2 (j < nums2.length) :
        //      j is less than nums2.length
        // Rule 3 (nums1[i] == nums2[j]) :
        //      current element in nums1 is equal to current element in nums2
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        // Rule 1 (j == nums2.length) :
        //      Pointer J already iterate all element in nums2
        // Rule 2 (i < nums1.length && nums1[i] > nums2[j]) :
        //      Pointer I didn't iterate all element in nums1 and
        //      current element in 'nums1' is 'GREATER' than current element in 'nums2'
        //      If nums2[j] is null then it will return true
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }

    // nums1 : [3, 4, 6, 5], i: 0
    // arg1 : []

    // nums2: [9, 1, 2, 5, 8, 3], ansLen - i: 5
    // arg2 : [9, 2, 5, 8, 3]

    // nums1: [3, 4, 6, 5], i: 1
    // arg1 : [6]

    // nums2: [9, 1, 2, 5, 8, 3], ansLen - i: 4
    // arg2 : [9, 5, 8, 3]
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