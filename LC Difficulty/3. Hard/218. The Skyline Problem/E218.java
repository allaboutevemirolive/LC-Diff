import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class E218 {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        LinkedList<int[]> result = (LinkedList<int[]>) divideAndConquer(buildings, 0, buildings.length - 1);
        List<List<Integer>> finalResult = convertToListOfLists(result);
        return finalResult;
    }

    private LinkedList<int[]> divideAndConquer(int[][] buildings, int start, int end) {
        LinkedList<int[]> result = new LinkedList<>();
        if (start > end) {
            return result;
        }
        if (start == end) {
            result.add(new int[] { buildings[start][0], buildings[start][2] });
            result.add(new int[] { buildings[start][1], 0 });
            return result;
        }
        int mid = (start + end) / 2;
        LinkedList<int[]> leftResult = divideAndConquer(buildings, start, mid);
        LinkedList<int[]> rightResult = divideAndConquer(buildings, mid + 1, end);
        result = merge(leftResult, rightResult);
        return result;
    }

    private LinkedList<int[]> merge(LinkedList<int[]> leftResult, LinkedList<int[]> rightResult) {
        LinkedList<int[]> result = new LinkedList<>();
        int height1 = 0, height2 = 0;
        while (!leftResult.isEmpty() || !rightResult.isEmpty()) {
            int x1, x2;
            x1 = leftResult.isEmpty() ? Integer.MAX_VALUE : leftResult.peekFirst()[0];
            x2 = rightResult.isEmpty() ? Integer.MAX_VALUE : rightResult.peekFirst()[0];
            int x;
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
        return result;
    }

    private List<List<Integer>> convertToListOfLists(LinkedList<int[]> result) {
        List<List<Integer>> finalResult = new ArrayList<>();
        for (int[] entry : result) {
            finalResult.add(List.of(entry[0], entry[1]));
        }
        return finalResult;
    }

}
