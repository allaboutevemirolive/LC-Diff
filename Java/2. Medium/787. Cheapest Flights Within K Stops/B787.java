import java.util.Arrays;

class B787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Initialize an array to keep track of the minimum distance from the source to each destination
        int[] distance = new int[n];
        // Fill the array with the maximum possible distance
        Arrays.fill(distance, Integer.MAX_VALUE);
        // The distance from the source to the source is 0
        distance[src] = 0;

        // Loop through the number of stops (k)
        for (int i = 0; i <= k; i++) {
            // If there is no route possible, exit the loop
            if (isRoutePossible(distance, flights)) {
                break;
            }
        }
        // Return the minimum distance to the destination, or -1 if there is no route
        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }

    // Helper function to check if a route is possible from the current minimum distances
    private boolean isRoutePossible(int[] dist, int[][] flights) {
        // Copy the minimum distances array
        int[] copy = Arrays.copyOf(dist, dist.length);
        boolean result = true;

        // Loop through all the flights
        for (int[] flight : flights) {
            int src = flight[0];
            int dst = flight[1];
            int cost = flight[2];

            // If the minimum distance from the source to the destination is greater than the minimum distance from the source to the flight's origin plus the flight's cost
            if (copy[src] < Integer.MAX_VALUE && dist[dst] > dist[src] + cost) {
                // Update the minimum distance to the destination
                dist[dst] = cost + copy[src];
                result = false;
            }
        }

        return result;
    }
}
