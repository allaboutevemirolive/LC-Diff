import java.util.*;

class B239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        // sliding window can move n - k + 1 times, 
        // and we need to store the maximum value for each window position.
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // remove elements outside the current window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                // If the first element of the deque is outside the current window,
                // remove it from the deque
                deque.pollFirst();
            }
            // remove elements that are smaller than the current element
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                // If the last element of the deque is smaller than the current element,
                // remove it from the deque, since it cannot be the maximum in the current window
                deque.pollLast();
            }
            deque.offerLast(i); // add the current element to the deque
            // add the maximum value to the result array
            if (i >= k - 1) {
                // The maximum value of the current window is always the first element of the deque
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }
}
