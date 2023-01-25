import java.util.HashMap;
import java.util.Map;

public class B0001 {
    
    public static int[] twoSum(int[] nums, int target) {
        // Create a map to store the indices of the elements in the array
        Map<Integer, Integer> map = new HashMap<>();
        
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Calculate the complement (the element that, when added to the current element, gives the target)
            int complement = target - nums[i];
            
            // If the complement is in the map, return the indices of the current element and the complement
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            
            // Otherwise, add the current element and its index to the map
            map.put(nums[i], i);
        }
        
        // If the target elements were not found, return an empty array
        return new int[] {};
    }
}
