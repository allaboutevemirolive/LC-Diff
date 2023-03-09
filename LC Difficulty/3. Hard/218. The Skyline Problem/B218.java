import java.util.*;

public class B218 {

    public static List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> heights = calculateHeights(buildings);
        // Sort the list base on x coordinate, if there is same number in x coordinate,
        // then it sort the same number in x coordinate base on y coordinate
        heights.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        // Store height in descending order
        TreeMap<Integer, Integer> heightMap = new TreeMap<>(Collections.reverseOrder());
        // Base height(ground) is 0 and set it as only occur once
        // If there is more height in heightMap,
        // it's mean there is multiple building with multiple height is layered
        heightMap.put(0, 1);
        // Set previous height to Base ground which is 0
        // need this to compare with new height for left edge(negative); Not compare it with height for right edge (positive)
        int prevHeight = 0;
        // Store skyline formed
        List<List<Integer>> skyline = new ArrayList<>();
        for (int[] height : heights) {
            // Determine if the height is for left edge of right edge
            updateHeightMap(height, heightMap);
            // get current maximum height
            // especially if updateHeightMap method found one complete building and
            // there is another building in same position with different height is layered :
            // - building in same position with less height is layered
            // - building in same position with more height is layered
            int currHeight = heightMap.firstKey();
            // previous and current height is same then the current coordinate is still in a same building
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
            // Store in (x, y) format
            // x : Building position
            // y : Building height
            // We negate y to negative to mark it as left edge of current building
            heights.add(new int[]{building[0], -building[2]});
            // Right edge of current building
            heights.add(new int[]{building[1], building[2]});
        }
        return heights;
    }

    private static void updateHeightMap(int[] height, TreeMap<Integer, Integer> heightMap) {
        // Negative mean, we found height of the left edge of the building
        if (height[1] < 0) {
            // If height is for left edge of the building,
            // we store the height of the left edge of the building and set to occur once
            heightMap.put(-height[1], heightMap.getOrDefault(-height[1], 0) + 1);
        } else {
            // Positive mean, we found height of the right edge of the building
            // Get total number of how many y(height) appear in heightMap
            int count = heightMap.get(height[1]);
            // If the height of the building already appear, then we remove height of entire building from heightMap
            // The code tell us that it already found one complete building (right edge + left edge)
            if (count == 1) {
                heightMap.remove(height[1]);
            } else {
                heightMap.put(height[1], count - 1);
            }
        }
    }
}
