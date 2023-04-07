import java.util.Arrays;
import java.util.PriorityQueue;

public class y295arrSort {

    public static void main(String[] args) {
        y295arrSort sorter = new y295arrSort();
        int[] nums = {5, 2, 8, 1, 9, 3};
        int[] sorted = sorter.sortArray(nums);
        System.out.println(Arrays.toString(sorted)); // output: [1, 2, 3, 5, 8, 9]
    }

    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    
    public int[] sortArray(int[] nums) {
        // Add each number to the appropriate heap
        for (int num : nums) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
            if (maxHeap.size() < minHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }
        
        // Combine the two heaps to get the sorted array
        int[] sorted = new int[nums.length];
        int i = 0;
        while (!maxHeap.isEmpty()) {
            sorted[i++] = maxHeap.poll();
        }
        while (!minHeap.isEmpty()) {
            sorted[i++] = minHeap.poll();
        }
        
        return sorted;
    }
    
    
}
