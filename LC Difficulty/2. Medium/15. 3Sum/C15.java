import java.util.*;
public class C15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        // loop through the nums array starting from 0 to the second to last element
        for (int currentIndex = 0; currentIndex < nums.length - 2; currentIndex++) {
            // check if the current element is unique compared to the previous one
            if (currentIndex == 0 || nums[currentIndex] != nums[currentIndex - 1]) {
                int leftPointer = currentIndex + 1;
                int rightPointer = nums.length - 1;
                int targetSum = 0 - nums[currentIndex];

                // while the left and right pointers have not crossed over each other
                while (leftPointer < rightPointer) {
                    // if the sum of the left and right pointer elements is equal to the target sum
                    if (nums[leftPointer] + nums[rightPointer] == targetSum) {
                        // add the triplet to the result list
                        result.add(Arrays.asList(nums[currentIndex], nums[leftPointer], nums[rightPointer]));

                        // move the left pointer to the right until a unique number is found
                        while (leftPointer < rightPointer && nums[leftPointer] == nums[leftPointer + 1]) {
                            leftPointer++;
                        }
                        // move the right pointer to the left until a unique number is found
                        while (leftPointer < rightPointer && nums[rightPointer] == nums[rightPointer - 1]) {
                            rightPointer--;
                        }

                        leftPointer++;
                        rightPointer--;
                    }
                    // if the sum of the left and right pointer elements is less than the target sum
                    else if (nums[leftPointer] + nums[rightPointer] < targetSum) {
                        leftPointer++;
                    }
                    // if the sum of the left and right pointer elements is greater than the target sum
                    else {
                        rightPointer--;
                    }
                }
            }
        }
        return result;
    }
}