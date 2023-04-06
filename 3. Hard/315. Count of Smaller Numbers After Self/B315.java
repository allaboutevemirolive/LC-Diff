import java.util.Arrays;
import java.util.List;

class B315 {

    public List<Integer> countSmaller(int[] nums) {
        
        int minNum = Integer.MAX_VALUE;
        int maxNum = Integer.MIN_VALUE;
        
        for (int num : nums) {
            minNum = Math.min(minNum, num);
            maxNum = Math.max(maxNum, num);
        }
        
        minNum--;
        
        int[] count = new int[maxNum - minNum + 1];
        
        Integer[] result = new Integer[nums.length];
        
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            int numIndex = num - minNum - 1;
            int smallerCount = 0;

            while (numIndex > 0) {
                smallerCount += count[numIndex];
				// notice minus "-" sign
                numIndex -= (-numIndex & numIndex);
            }
            result[i] = smallerCount;
			// assign new numIndex
            numIndex = num - minNum;
            while (numIndex < count.length) {
                count[numIndex]++;
				// notice plus "+" sign
                numIndex += (-numIndex & numIndex);
            }
        }
        return Arrays.asList(result);
    }
}
