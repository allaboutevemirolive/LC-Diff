public class C0016 {
    public int threeSumClosest(int[] nums, int t) {
        // If the length of the input array is less than 44, use the built-in Arrays.sort method to sort the array
        if (nums.length < 44) {
            java.util.Arrays.sort(nums);
        }
        // Otherwise, use a counting sort algorithm to sort the array
        else {
            // Create an array to store the count of each number
            byte[] a = new byte[2001];
            // Increment the count for each number in the input array
            for (int v : nums) {
                a[v + 1000]++;
            }
            // Iterate through the counts and add each number to the input array
            for (int z = 0, c = 0; z < 2001; ++z) {
                int w = a[z];
                // Add each number to the input array
                while (w-- != 0) {
                    nums[c++] = z - 1000;
                }
            }
        }
    
        // Initialize variables to track the indices of the array
        int i = 0;
        int n = nums.length - 1;
    
        // Calculate the sum of the last two elements in the sorted array
        int sumLast2 = nums[n - 1] + nums[n];
        // Iterate over the array and skip elements that are too low to be included in the minimum sum
        for (int minLow = t - sumLast2, end = n - 2; i < end && nums[i] <= minLow; ++i) {}
        // If all elements have been skipped, return the sum of the last three elements
        if (i == n - 2) {
            return sumLast2 + nums[n - 2];
        }
    
        // Calculate the sum of the first two elements in the sorted array
        int sumFirst2 = nums[i] + nums[i + 1];
        // Iterate over the array and skip elements that are too high to be included in the minimum sum
        for (int maxHigh = t - sumFirst2, end = i + 2; n > end && nums[n] >= maxHigh; --n) {}
        // If all elements have been skipped, return the sum of the first three elements
        if (n == i + 2) {
            return sumFirst2 + nums[n];
        }
    
        // Initialize variables to track the minimum sum and its absolute difference from the target value
        int minAbs = 0x7fffffff;
        int minSum = 0;
        // Iterate over the remaining elements of the array and find the minimum sum
        for (int end = n - 1; i < end; ++i) {
            int num_i = nums[i];
    
            // Use two pointers to find the minimum sum of three elements
            for (int j = i + 1, k = n; j < k;) {
				int sum = num_i + nums[j] + nums[k];
				if (sum == t)
					return sum;

				int abs;
				if (sum > t) {
					abs = sum - t;
					k--;
				} else {
					abs = t - sum;
					j++;
				}
				if (abs < minAbs) {
					minAbs = abs;
					minSum = sum;
				}
			}
		}
		return minSum;
	}
}
