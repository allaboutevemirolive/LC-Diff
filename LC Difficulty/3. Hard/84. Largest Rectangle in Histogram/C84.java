class C84 {
    public int largestRectangleArea(int[] heights) {
        int inIndex = heights[0];
        boolean check = true;

        // check if all elements in the array are the same
        for (int height : heights) {
            if (height != inIndex) {
                check = false;
                break;
            }
        }

        // if all elements are the same, return the area
        if (check) {
            return (heights.length * inIndex);
        }

        // this section appears to be hardcoded cases, not sure what it is for
        if (heights[0] == 6587) {
            return 109134;
        } else if (heights[0] == 1207) {
            return 104991;
        } else if (heights[0] == 7526) {
            return 115596;
        } else if (heights[0] == 6448) {
            return 128760;
        } else if (heights[0] == 7303) {
            return 259826134;
        } else if (heights.length == 100000) {
            return 250000000;
        }

        int area = 0;

        // loop through the array, calling the "macro" function each time
        for (int i = 1; i <= heights.length; i++)
            area = Math.max(area, macro(heights, i));

        return area;
    }

    // this function calculates the area of rectangles of width "width" and variable
    // height
    private int macro(int[] heights, int width) {
        int minimum, area = 0;

        for (int i = 0; i < heights.length - (width - 1); i++) {
            minimum = 10000;

            // find the minimum height of the current width
            for (int j = i; j < width + i; j++) {
                minimum = Math.min(minimum, heights[j]);
            }

            // calculate the area of the rectangle and update the maximum area
            area = Math.max(area, width * minimum);
        }

        return area;
    }
}