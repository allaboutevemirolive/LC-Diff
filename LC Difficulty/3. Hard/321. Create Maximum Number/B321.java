import java.util.Arrays;

class B321 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        int[] result = new int[k];
        System.out.println("n = " + n + ", m = " + m + ", k = " + k);
        System.out.println("result: \n" + Arrays.toString(result));

        for (int i = Math.max(0, k - m); i <= Math.min(k, n); i++) {

            System.out.println("====================================");

            System.out.println("i = " + i);
            System.out.println("nums1: \n" + Arrays.toString(nums1));
            int[] max1 = getMax(nums1, i);
            System.out.println("max1: \n" + Arrays.toString(max1));

            System.out.println();

            System.out.println("k - i = " + (k - i));
            System.out.println("nums2: \n" + Arrays.toString(nums2));
            int[] max2 = getMax(nums2, k - i);
            System.out.println("max2: \n" + Arrays.toString(max2));

            System.out.println();

            int[] merged = merge(max1, max2);
            System.out.println("merged: \n" + Arrays.toString(merged));

            System.out.println();

            int diff = compare(merged, 0, result, 0);
            System.out.println("diff = " + diff);

            System.out.println();

            System.out.println("result(before): \n" + Arrays.toString(result));
            if (diff > 0) {
                result = merged;
            }
            System.out.println("result(after): \n" + Arrays.toString(result));
        }
        
        return result;
    }
    
    private int[] getMax(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[k];
        int index = 0;
        
        for (int i = 0; i < n; i++) {
            while (n - i > k - index && index > 0 && nums[i] > result[index - 1]) {
                index--;
            }
            if (index < k) {
                result[index] = nums[i];
                index++;
            }
        }
        
        return result;
    }
    
    private int[] merge(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] result = new int[n + m];
        int i = 0;
        int j = 0;
        int index = 0;
        
        while (i < n && j < m) {
            if (compare(nums1, i, nums2, j) > 0) {
                result[index] = nums1[i];
                i++;
            } else {
                result[index] = nums2[j];
                j++;
            }
            index++;
        }
        
        while (i < n) {
            result[index] = nums1[i];
            i++;
            index++;
        }
        
        while (j < m) {
            result[index] = nums2[j];
            j++;
            index++;
        }
        
        return result;
    }
    
    private int compare(int[] nums1, int i, int[] nums2, int j) {
        int n = nums1.length;
        int m = nums2.length;
        
        while (i < n && j < m && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        
        if (i == n) {
            return -1;
        }
        
        if (j == m) {
            return 1;
        }
        
        return nums1[i] - nums2[j];
    }
}