class B1162 {
    // Function to find the maximum distance of a cell from a land
    public int maxDistance(int[][] grid) {
        // Number of rows in the grid
        int rows = grid.length;
        // Number of columns in the grid
        int columns = grid[0].length;
        // Initialize the maximum distance to be the sum of rows and columns
        int maximumDistance = rows + columns;

        // Loop through all the cells of the grid from top to bottom and from left to right
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                // Skip if the cell is a land
                if (grid[row][col] == 1) {
                    continue;
                }
                // Initialize the distances from the closest land to be maximum distance
                int top = maximumDistance;
                int left = maximumDistance;

                // Check if the top cell exists
                if (row - 1 >= 0) {
                    top = grid[row - 1][col];
                }
                // Check if the left cell exists
                if (col - 1 >= 0) {
                    left = grid[row][col - 1];
                }
                // Update the distance of the current cell to be the minimum distance of the top
                // and left cells + 1
                grid[row][col] = Math.min(top, left) + 1;
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

        // Loop through all the cells of the grid from bottom to top and from right to left
        for (int row = rows - 1; row >= 0; row--) {
            for (int col = columns - 1; col >= 0; col--) {
                // Skip if the cell is a land
                if (grid[row][col] == 1) {
                    continue;
                }
                // Initialize the distances from the closest land to be maximum distance
                int bottom = maximumDistance;
                int right = maximumDistance;

                // Check if the bottom cell exists
                if (row + 1 < rows) {
                    bottom = grid[row + 1][col];
                }
                // Check if the right cell exists
                if (col + 1 < columns) {
                    right = grid[row][col + 1];
                }
                // Update the distance of the current cell to be the minimum distance of the
                // current distance, bottom and right cells + 1
                grid[row][col] = Math.min(grid[row][col], Math.min(bottom, right) + 1);
            }
        }

        System.out.println("-----");
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

        // Initialize the maximum distance to be the minimum integer value
        int max = Integer.MIN_VALUE;
        // Loop through all the cells of the grid to find the maximum distance
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                // Update the maximum distance if the current distance is larger
                max = Math.max(max, grid[row][col]);
            }
        }

        // Return the maximum distance
        // If the maximum distance is equal to the sum of rows and columns + 1 or 0,
        // then return -1 as it is not possible to reach a land
        // Otherwise, return the maximum distance minus 1
        return max - 1 == columns + rows + 1 || max - 1 == 0 ? -1 : max - 1;

    }
}