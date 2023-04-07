import java.util.Arrays;

class C330 {
    public int minPatches(int[] nums, int n) {
        // index for iterating through the nums array
        int i = 0;
        // keeps track of the current maximum reachable maxReachableValue
        long maxReachableValue = 1;
        // counts how many patches have been added to the array
        int patch = 0;
        while (maxReachableValue <= n) {

            System.out.println("maxReachableValue: " + maxReachableValue + ", i: " + i + ", patch: " + patch);
            try {
                System.out.println("nums[i]: " + nums[i]);
            } catch (Exception e) {
                System.out.println("nums[i]: " + "null");
            }
            System.out.println("nums: " + Arrays.toString(nums) + ", n: " + n);
            System.out.println("i == nums.length: " + (i == nums.length));
            try {
                System.out.println("maxReachableValue < nums[i]: " + (maxReachableValue < nums[i]));
            } catch (Exception e) {
                System.out.println("maxReachableValue < nums[i]: " + "null");
            }
            System.out.println();

            if (i == nums.length || maxReachableValue < nums[i]) {
                System.out.println("if");
                System.out.println("maxReachableValue(before) (2 * maxReachableValue): " + maxReachableValue);
                maxReachableValue = 2 * maxReachableValue;
                patch++;
                System.out.println("maxReachableValue(after): " + maxReachableValue);
                System.out.println("patch(incremented): " + patch);
            } else {
                System.out.println("else");
                System.out.println("maxReachableValue(before): " + maxReachableValue);
                System.out.println("nums[i]: " + nums[i]);
                maxReachableValue += nums[i];
                i++;
                System.out.println("maxReachableValue(after): " + maxReachableValue);
                System.out.println("i(incremented): " + i);
            }
            System.out.println();
            System.out.println("==================================");
        }
        return patch;
    }
}