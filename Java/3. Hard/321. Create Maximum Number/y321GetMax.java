import java.util.Arrays;

public class y321GetMax {

    public static void main(String[] args) { // output : [8, 12, 3]
        int[] nums = {5, 2, 8, 12, 3};
        int k = 3;
        int[] result = getMax(nums, k);
        System.out.println(Arrays.toString(result));
      }
    
      private static int[] getMax(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[k];
        int index = 0;
    
        for (int i = 0; i < n; i++) {
			// Check if the remaining nums is more than available room in K
			// If the remainin nums is bigger, than we need to execute this code
			// If the remaining num is lesser, than we skip this code as nothing need to worry
			// limit the index to more than 0. In case index is set to negative than this code wont execute
			// Check if current number is bigger than 'each' of stored result
			// If current num is bigger than 'each' of stored result, than the next line it will replace the lower num in result
            while (n - i > k - index && index > 0 && nums[i] > result[index - 1]) {
                index--;
            }
			// check if there any room for the current number
            if (index < k) {
                result[index] = nums[i];
                index++;
            }
        }
    
        return result;
      }
}
