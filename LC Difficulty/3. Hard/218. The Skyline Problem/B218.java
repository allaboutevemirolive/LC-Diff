import java.util.*;

public class B218 {

    public static List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> heights = calculateHeights(buildings);
        Collections.sort(heights, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        TreeMap<Integer, Integer> heightMap = new TreeMap<>(Collections.reverseOrder());
        heightMap.put(0, 1);
        int prevHeight = 0;
        List<List<Integer>> skyline = new ArrayList<>();
        for (int[] height : heights) {
            updateHeightMap(height, heightMap);
            int currHeight = heightMap.firstKey();
            if (prevHeight != currHeight) {
                skyline.add(Arrays.asList(height[0], currHeight));
                prevHeight = currHeight;
            }
        }
        return skyline;
    }

    private static List<int[]> calculateHeights(int[][] buildings) {
        List<int[]> heights = new ArrayList<>();
        for (int[] building : buildings) {
            heights.add(new int[]{building[0], -building[2]});
            heights.add(new int[]{building[1], building[2]});
        }
        return heights;
    }

    private static void updateHeightMap(int[] height, TreeMap<Integer, Integer> heightMap) {
        if (height[1] < 0) {
            heightMap.put(-height[1], heightMap.getOrDefault(-height[1], 0) + 1);
        } else {
            int count = heightMap.get(height[1]);
            if (count == 1) {
                heightMap.remove(height[1]);
            } else {
                heightMap.put(height[1], count - 1);
            }
        }
    }
}
