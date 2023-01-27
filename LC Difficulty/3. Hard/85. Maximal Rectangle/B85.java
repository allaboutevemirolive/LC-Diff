import java.util.Arrays;

class B85 {
    public int maximalRectangle(char[][] matrix) {
        // check if input matrix is empty or null
        if (matrix == null || matrix.length == 0)
            return 0;
        int m = matrix.length, n = matrix[0].length;
        // create three arrays for left, right and height
        int[] left = new int[n], right = new int[n], height = new int[n];
        // fill right array with n
        Arrays.fill(right, n);
        int maxArea = 0;
        // iterate through each row
        for (int i = 0; i < m; i++) {
            int cur_left = 0, cur_right = n;
            // iterate through each column
            for (int j = 0; j < n; j++) {
                // if current element is 1, increase height
                if (matrix[i][j] == '1') {
                    height[j]++;
                } else {
                    // if current element is 0, reset height
                    height[j] = 0;
                }
            }
            // iterate through each column
            for (int j = 0; j < n; j++) {
                // if current element is 1, update left array
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], cur_left);
                } else {
                    // if current element is 0, reset left array and update cur_left
                    left[j] = 0;
                    cur_left = j + 1;
                }
            }
            // iterate through each column in reverse
            for (int j = n - 1; j >= 0; j--) {
                // if current element is 1, update right array
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], cur_right);
                } else {
                    // if current element is 0, reset right array and update cur_right
                    right[j] = n;
                    cur_right = j;
                }
            }
            // iterate through each column
            for (int j = 0; j < n; j++) {
                // update maxArea by comparing it with current area
                maxArea = Math.max(maxArea, (right[j] - left[j]) * height[j]);
            }
        }
        // return maxArea
        return maxArea;
    }
}