
class B330 {
    public int minPatches(int[] nums, int n) {
        // index for iterating through the nums array
        int i = 0;
        // keeps track of the current maximum reachable maxReachableValue 
        long maxReachableValue  = 1;
        // counts how many patches have been added to the array
        int patch = 0;
        while (maxReachableValue  <= n) {
            // If the current maxReachableValue  is less than the current element in the array or 
            // we have reached the end of the array, 
            // we know that we 'cannot' represent all numbers up to the 'current maxReachableValue ' plus the 'current element'. 
            // Therefore, we double the current maxReachableValue  and add a patch to the array.
            if (i == nums.length || maxReachableValue  < nums[i]) {
                maxReachableValue  = 2 * maxReachableValue ;
                patch++;
            } else {
                // If the current maxReachableValue  is greater than or equal to the current element in the array, 
                // we know that we 'can' represent all numbers up to the 'current maxReachableValue ' plus the 'current element'. 
                // Therefore, we add the current element to the current maxReachableValue  and move to the next element.
                maxReachableValue  += nums[i];
                i++;
            }
        }
        return patch;
    }
}