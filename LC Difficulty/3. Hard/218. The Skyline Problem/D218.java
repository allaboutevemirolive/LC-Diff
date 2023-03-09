import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class D218 {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        // Create a linked list to store the skyline
        LinkedList<int[]> result = (LinkedList<int[]>) divideAndConquer(buildings, 0, buildings.length - 1);
        
        // Convert the linked list to the desired output format
        List<List<Integer>> finalResult = new ArrayList<>();
        for (int[] entry : result) {
            finalResult.add(List.of(entry[0], entry[1]));
        }
        
        // Return the final result
        return finalResult;
    }

    public List<int[]> divideAndConquer(int[][] buildings, int start, int end) {
        // Create a linked list to store the skyline for the current subproblem
        LinkedList<int[]> result = new LinkedList<>();
        
        // Base case: when there are no buildings in the current subproblem
        if (start > end) {
            return result;
        }
        
        // Base case: when there is only one building in the current subproblem
        if (start == end) {
            result.add(new int[] { buildings[start][0], buildings[start][2] });
            result.add(new int[] { buildings[start][1], 0 });
            return result;
        }
        
        // Recursive case: divide the problem into two subproblems
        int mid = (start + end) / 2;
        LinkedList<int[]> leftResult = (LinkedList<int[]>) divideAndConquer(buildings, start, mid);
        LinkedList<int[]> rightResult = (LinkedList<int[]>) divideAndConquer(buildings, mid + 1, end);
        
        // Merge the results of the two subproblems
        int height1 = 0, height2 = 0;
        while (!leftResult.isEmpty() || !rightResult.isEmpty()) {
            int x1 = 0, x2 = 0;
            x1 = leftResult.isEmpty() ? Integer.MAX_VALUE : leftResult.peekFirst()[0];
            x2 = rightResult.isEmpty() ? Integer.MAX_VALUE : rightResult.peekFirst()[0];
            int x = 0;
            if (x1 < x2) {
                x = x1;
                height1 = leftResult.pollFirst()[1];
            } else if (x1 > x2) {
                x = x2;
                height2 = rightResult.pollFirst()[1];
            } else {
                x = x1;
                height1 = leftResult.isEmpty() ? Integer.MIN_VALUE : leftResult.pollFirst()[1];
                height2 = rightResult.isEmpty() ? Integer.MIN_VALUE : rightResult.pollFirst()[1];
            }
            int maxHeight = Math.max(height1, height2);
            if (result.isEmpty() || result.peekLast()[1] != maxHeight) {
                result.add(new int[] { x, maxHeight });
            }
        }
        
        // Return the final skyline for the current subproblem
        return result;
    }
}
