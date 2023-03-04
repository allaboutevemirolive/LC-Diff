class B174 {

    // This method calculates the minimum initial health required for a knight 
    // to traverse the dungeon from top-left to bottom-right.

    // It initializes a memoization array to store the minimum health required 
    // at each room in the dungeon and returns the result of the helper method.
    int calculateMinimumHP(int[][] dungeon) {
        int[][] memo = new int[dungeon.length][dungeon[0].length];
        return helper(dungeon, memo,0, 0);
    }

    int helper(int[][] dungeon, int[][]memo, int i, int j) {     
        // Base case : we have crossed the matrix, ie. out of bound
        // if current row crosses then my row is below the princess or
        // if current column crosses then my column is ahead the column of princess
        // and because we can go only down and right so we won't be able to reach princess
        if (i >= dungeon.length || j >= dungeon[0].length) {
            return Integer.MAX_VALUE;
        }

        // Base Case : we have reached our destination ie. last cell
        // If the knight has reached the princess (bottom-right corner), 
        // calculate the minimum health required based on the value of the current room.
        if (i == dungeon.length - 1 && j == dungeon[0].length - 1) {
            return (dungeon[i][j] <= 0) ? -dungeon[i][j] + 1 : 1;
        }
            
        // If the minimum health required for the current room is already calculated and 
        // stored in memoization array, return it.
        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        // now we must try all possible paths , we ask our right and down cell
        int goRight = helper(dungeon, memo, i, j + 1);
        int goDown = helper(dungeon, memo, i + 1, j);

        // min of either values and then cost of this cell
        int minHealthRequired = Math.min(goRight, goDown) - dungeon[i][j];

        // Store the minimum health required to reach the princess 
        // from the current room in memoization array.
        memo[i][j] = (minHealthRequired <= 0) ? 1 : minHealthRequired;
        return memo[i][j];
    }

}
