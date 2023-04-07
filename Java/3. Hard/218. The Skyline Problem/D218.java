import java.util.ArrayList;
import java.util.List;

class D218 {
    // Constants for building array indices
    static final int LEFT = 0;
    static final int RIGHT = 1;
    static final int HEIGHT = 2;

    public List<List<Integer>> getSkyline(int[][] buildings) {
        // Create a sentinel node at the start of the skyline to simplify insertion logic
        int n = buildings.length;
        int minX = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minX = Math.min(minX, buildings[i][LEFT]);
        }
        // Create a sentinel node at the start of the skyline to simplify insertion logic
        T218 skyline = new T218(minX, 0);
        skyline.insert(new T218(Integer.MAX_VALUE, 0));
        // Start at the sentinel node
        T218 current = skyline;

        for (int i = 0; i < buildings.length; i++) {
            // Extract building parameters for readability
            int left = buildings[i][LEFT];
            int right = buildings[i][RIGHT];
            int height = buildings[i][HEIGHT];
            // Move to the correct position for the start of the building
            while (left >= current.next.x) {
                current = current.next;
            }
            // Iterate over nodes until the end of the building is reached
            for (T218 node = current; right > node.x; node = node.next) {
                // If the building is shorter than the current node, skip to the next node
                if (height <= node.h) {
                    continue;
                }
                // Remember this node as the stopping point for insertion
                T218 stop = node;
                // Move forward to find the stopping point for the insertion
                while (stop.next != null && stop.next.x < right && stop.next.h <= height) {
                    stop = stop.next;
                }

                // Handle cases based on the relationship between the building and the current node
                if (left <= node.x) {
                    if (right >= stop.next.x) {
                        // The building spans multiple nodes, so link the current node to the stopping point
                        node.next = stop.next;
                        node.h = height;
                    } else if (node == stop) {
                        // The building fits entirely within a single node
                        node.insert(new T218(right, node.h));
                        node.h = height;
                        break;
                    } else {
                        // The building overlaps two nodes, so split the node and insert the building
                        stop.x = right;
                        node.h = height;
                        node.next = stop;
                        break;
                    }
                } else {
                    if (right >= stop.next.x) {
                        if (node == stop) {
                            // The building is taller than the current node, so insert a new node
                            node.insert(new T218(left, height));
                        } else {
                            // The building overlaps multiple nodes, so link the current node to the stopping point
                            node.next = stop;
                            stop.x = left;
                            stop.h = height;
                        }
                        break;
                    } else if (node == stop) {
                        // The building fits entirely within a single node
                        node.insert(new T218(left, height));
                        node.next.insert(new T218(right, node.h));
                        break;
                    } else {
                        // The building overlaps two nodes, so split the node and insert the building
                        node.next = stop;
                        node.insert(new T218(left, height));
                        stop.x = right;
                        break;
                    }
                }
                node = stop;
            }
        }

        // Extract the skyline from the linked list of nodes
        List<List<Integer>> result = new ArrayList<>();
        while (skyline != null) {
            int height = skyline.h;
            result.add(List.of(skyline.x, height));
            while ((skyline = skyline.next) != null && skyline.h == height) {
            }
        }
        return result;
    }
}