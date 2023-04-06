class D84 {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;

        int[] stackHeight = new int[heights.length];
        int[] stackStartingIdx = new int[heights.length];
        int next = 0;

        stackHeight[next] = heights[0];
        stackStartingIdx[next] = 0;
        next++;

        int lastIdx = 0;
        int i;

        for (i = 1; i < heights.length; i++) {
            if (heights[i] >= stackHeight[next - 1]) {
                stackHeight[next] = heights[i];
                stackStartingIdx[next] = i;
                next++;
                continue;
            }

            while (next > 0 && stackHeight[next - 1] > heights[i]) {
                lastIdx = stackStartingIdx[next - 1];
                maxArea = Math.max(maxArea, stackHeight[next - 1] * (i - stackStartingIdx[next - 1]));
                next--;
            }

            stackHeight[next] = heights[i];
            stackStartingIdx[next] = lastIdx;
            next++;
        }

        while (next > 0) {
            maxArea = Math.max(maxArea, stackHeight[next - 1] * (i - stackStartingIdx[next - 1]));
            next--;
        }

        return maxArea;
    }
}
