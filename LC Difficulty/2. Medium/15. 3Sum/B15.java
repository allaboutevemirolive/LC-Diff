import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class B15 {
    // field to store the result of three sum
    private List<List<Integer>> result;

    // method to find all three sum combinations in the given array of integers
    public List<List<Integer>> threeSum(int[] nums) {
        int target = 0; // the target sum we are looking for

        return new AbstractList<List<Integer>>() {
            // method to get the List of Integers at a particular index
            public List<Integer> get(int index) {
                initialize();
                return result.get(index);
            }

            // method to get the size of the result list
            public int size() {
                initialize();
                return result.size();
            }

            // helper method to find all three sum combinations
            private void initialize() {
                // if the result is already initialized, return
                if (result != null) return;
                
                // sort the given array of integers
                Arrays.sort(nums);

                // pointers for the left and right end of the array
                int leftPointer;
                int rightPointer;
                int currentSum;

                // a set to store the unique three sum combinations
                Set<List<Integer>> tempResult = new HashSet<>();

                // loop through the array of integers
                for (int i = 0; i < nums.length - 2; ++i) {
                    // initialize the left pointer
                    leftPointer = i + 1;
                    // initialize the right pointer
                    rightPointer = nums.length - 1;

                    // loop through the array of integers with left and right pointers
                    while (leftPointer < rightPointer) {
                        // calculate the current sum
                        currentSum = nums[i] + nums[leftPointer] + nums[rightPointer];

                        // if the current sum is equal to the target sum
                        if (currentSum == target) {
                            // create a new list to store the three integers
                            List<Integer> triplet = new ArrayList<>();
                            triplet.add(nums[i]);
                            triplet.add(nums[leftPointer]);
                            triplet.add(nums[rightPointer]);
                            // add the triplet to the set of results
                            tempResult.add(triplet);
                        }

                        // if the current sum is less than the target sum
                        if (currentSum < target) ++leftPointer;
                        // if the current sum is greater than the target sum
                        else --rightPointer;
                    }
                }
                // convert the set of results to a list and store it in the result field
                result = new ArrayList<>(tempResult);
            }
        };
    }
}
