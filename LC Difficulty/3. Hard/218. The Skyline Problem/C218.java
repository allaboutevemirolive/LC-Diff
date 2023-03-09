// Importing required libraries
import java.util.*;

class C218 {
    public List<List<Integer>> getSkyline(int[][] buildings) {

        // Creating an ArrayList to store the skyline key points
        List<List<Integer>> skyline = new ArrayList<>();

        // Creating a TreeMap to store the buildings' information based on their x-coordinates
        TreeMap<Integer, List<int[]>> buildingMap = new TreeMap<>();

        // Adding the buildings' information to the buildingMap
        for (int[] building : buildings) {
            buildingMap.computeIfAbsent(building[0], k -> new ArrayList<>()).add(building);
            buildingMap.computeIfAbsent(building[1], k -> new ArrayList<>()).add(building);
        }
        // Creating a PriorityQueue to store the heights of the buildings in decreasing order
        PriorityQueue<Integer> heightQueue = new PriorityQueue<>(Collections.reverseOrder());

        // Adding 0 as the initial height to the PriorityQueue
        heightQueue.offer(0);

        // Initializing the previous height as 0
        int prevHeight = 0;

        // Iterating through the x-coordinates of the buildings in the buildingMap
        for (int x : buildingMap.keySet()) {
            // Getting the list of buildings at the current x-coordinate
            List<int[]> currentBuildings = buildingMap.get(x);

            // Adding or removing the height of the buildings at the current x-coordinate to the heightQueue
            for (int[] building : currentBuildings) {
                if (building[0] == x) {
                    heightQueue.offer(building[2]);
                } else {
                    heightQueue.remove(building[2]);
                }
            }
            // Getting the current height by peeking at the heightQueue
            int currHeight = heightQueue.peek();
            // Adding the key point to the skyline if the current height is different from the previous height
            if (currHeight != prevHeight) {
                skyline.add(Arrays.asList(x, currHeight));
                prevHeight = currHeight;
            }
        }
        return skyline;
    }
}
