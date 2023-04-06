import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Pay attention to :
 * 
 * subsets.get(j)
 * subset.add(nums[i])
 * 
 * j = x
 * i = y
 * 
 * (x,y) = (j,i)
 * 
 * or maybe
 * 
 * (x,x,y) = (j,j,i)
 */
class B90 {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        // Initialize an empty list to store the subsets
        List<List<Integer>> subsets = new ArrayList<>();
        // Sort the input array to ensure that duplicates are next to each other
        Arrays.sort(nums);
        // Add an empty element to the subsetS list
        // Meaning, subsetS will start with an empty element 
        subsets.add(new ArrayList<>());
        int startIndex = 0, endIndex = 0;
        // For loop i, will iterate through the input array
        // For loop i, responsible for element in coordinate x in (x,y)
        // subsets.get(j)
        // Element x will be taken from subsetS at index J
        // Element in nums at index i will represent coordinates y in (x,y)
        for (int i = 0; i < nums.length; i++) {
            // If the current element is a duplicate of the previous element,
            // set the starting index to the end index of the previous iteration
            startIndex = (i > 0 && nums[i] == nums[i - 1]) ? endIndex : 0;
            // Update the end index to the current size of the subsets list
            // Responsible for iteration in nested for loop
            endIndex = subsets.size();
            // Iterate through the subsets starting from the start index
            for (int j = startIndex; j < endIndex; j++) {
                // Create a new subset, by adding the element in subsetS at index j to the new subset 
                // Element in subsetS at index j will represent coordinates x in (x,y)
                List<Integer> subset = new ArrayList<>(subsets.get(j));
                // Element in nums at index i will represent coordinates y in (x,y)
                // If element x is 0, and element y is full number like 2. Then, the answer is 2. Not (0,2).
                subset.add(nums[i]);
                // Add the new subset to the subsets list
                subsets.add(subset);
            }
        }
        // Return the final subsets list
        return subsets;
    }
}