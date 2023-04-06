import java.util.Arrays;

// maxArray()
class D321 {
    public int[] maxNumber(int[] nums1, int[] nums2, int ansLen) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] ans = new int[ansLen];

        for (int i = Math.max(0, ansLen - len2); i <= ansLen && i <= len1; ++i) {
            
            System.out.println("nums1: " + Arrays.toString(nums1) + ", i: " + i);
            int[] arg1 = maxArray(nums1, i);
            System.out.println("Calculated");
            System.out.println("arg1 : " + Arrays.toString(arg1));

            System.out.println("-----------------------------------");

            System.out.println("nums2: " + Arrays.toString(nums2) + ", ansLen - i: " + (ansLen - i));
            int[] arg2 = maxArray(nums2, ansLen - i);
            System.out.println("Calculated");
            System.out.println("arg2 : " + Arrays.toString(arg2));
            
            int[] candidate = merge(arg1, arg2, ansLen);
            if (greater(candidate, 0, ans, 0)) {
                ans = candidate;
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
        System.out.println("maxArray" );
        int len3 = nums.length;
        int[] ans = new int[ansLen];
        System.out.println("len3: " + len3);
        System.out.println("ans : \n" + Arrays.toString(ans));

        for (int i = 0, j = 0; i < len3; ++i) {
            System.out.println("------ for loop");
            System.out.println("i: " + i + ", j: " + j);
            System.out.println("ansLen: " + ansLen);
            while (len3 - i + j > ansLen && j > 0 && ans[j - 1] < nums[i]) {
                System.out.println("TRUE : while loop");
                j--;
                System.out.println("j: " + j);
            }
            if (j < ansLen) {
                System.out.println("TRUE : j < ansLen");
                ans[j++] = nums[i];
                System.out.println("ans: \n" + Arrays.toString(ans));
                System.out.println("j: " + j);
            } else {
                System.out.println("FALSE: j < ansLen");
            }
        }
        return ans;
    }
}