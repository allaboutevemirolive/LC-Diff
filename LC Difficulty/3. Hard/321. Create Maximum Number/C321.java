import java.util.Arrays;

// Main calculation
class C321 {
    public int[] maxNumber(int[] nums1, int[] nums2, int ansLen) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] ans = new int[ansLen];

        for (int i = Math.max(0, ansLen - len2); i <= ansLen && i <= len1; ++i) {
            System.out.println();
            System.out.println("i = " + i + " | ansLen - len2 = " + (ansLen - len2) + " | ansLen = " + ansLen + " | len1 = " + len1 + " | len2 = " + len2 + "");
            
            System.out.println();
            System.out.println("i: " + i + ", ansLen - i: " + (ansLen - i) + ", ansLen: " + ansLen);
            System.out.println("nums1: \n" + Arrays.toString(nums1));
            System.out.println("nums2: \n" + Arrays.toString(nums2));
            
            System.out.println();
            int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, ansLen - i), ansLen);
            System.out.println("candidate: \n" + Arrays.toString(candidate));
            System.out.println("ans(before): \n" + Arrays.toString(ans));

            System.out.println();
            if (greater(candidate, 0, ans, 0)) {
                System.out.println("TRUE : isGreater");
                ans = candidate;
                System.out.println("ans(after) : \n" + Arrays.toString(ans));
            } else {
                System.out.println("FALSE : isGreater");
                System.out.println("ans(after) : \n" + Arrays.toString(ans));
            }
            System.out.println("===================================");
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
            while (len3 - i + j > ansLen && j > 0 && ans[j - 1] < nums[i]) {
                j--;
            }
            if (j < ansLen) {
                ans[j++] = nums[i];
            }
        }
        return ans;
    }
}