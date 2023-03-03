import java.util.HashMap;
import java.util.Map;

class B142 {
    public int maxPoints(int[][] points) {
        // Get the number of points
        final int numPoints = points.length;
        // If there are at most 2 points, return the number of points
        if (numPoints <= 2) {
            return numPoints;
        }

        // Initialize the maximum number of points on a line
        int maxPointsOnLine = 2;

        // Iterate through all the points to find the maximum number of points on a line that pass through each point
        for (int i = 0; i < numPoints; i++) {
            maxPointsOnLine = Math.max(maxPointsOnLine, maxPointsOnLineForPoint(points[i][0], points[i][1], i + 1, points, numPoints));
        }

        // Return the maximum number of points on a line
        return maxPointsOnLine;
    }

    // Helper method to find the maximum number of points on a line that pass through a specific point
    private int maxPointsOnLineForPoint(int x, int y, int startPointIndex, int[][] points, int numPoints) {
        // Initialize the maximum number of points on a line
        int maxPointsOnLine = 2;
        // Create a map to store the slope and the number of points that are on the same line with the given point
        Map<Double, int[]> lines = new HashMap<>(numPoints - startPointIndex + 1, .95f);

        // Iterate through all the points that come after the given point
        for (int i = startPointIndex; i < numPoints; i++) {
            double slope;
            // If the point is on the same vertical line as the given point, set the slope to 0
            if (points[i][1] == y) {
                slope = 0.0;
            }
            // If the point is on the same horizontal line as the given point, set the slope to infinity
            else if (points[i][0] == x) {
                slope = Double.POSITIVE_INFINITY;
            }
            // Otherwise, calculate the slope of the line that passes through the two points
            else {
                // Best practice is to cast this expression with (double). You can also leave it.
                slope = (double) (points[i][1] - y) / (points[i][0] - x);
            }

            // Get the count of the number of points that are on the same line with the given point with the same slope
            int[] count = lines.get(slope);
            if (count == null) {
                // If the slope is not yet in the map, add it with an initial count of 2 (which includes the two points that define the line)
                lines.put(slope, new int[] { 2 });
            } else {
                // If the slope is already in the map, increment the count and update the maximum number of points on a line if necessary
                maxPointsOnLine = Math.max(maxPointsOnLine, ++count[0]);
            }
        }

        // Return the maximum number of points on a line that pass through the given point
        return maxPointsOnLine;
    }
}
