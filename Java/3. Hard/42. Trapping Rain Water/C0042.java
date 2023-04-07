public class C0042 {

    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }

        int left = 0, right = n - 1;
        int leftMax = height[left], rightMax = height[right];
        int trappedWater = 0;
        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                if (height[left] < leftMax) {
                    trappedWater += leftMax - height[left];
                } else {
                    leftMax = height[left];
                }
            } else {
                right--;
                if (height[right] < rightMax) {
                    trappedWater += rightMax - height[right];
                } else {
                    rightMax = height[right];
                }
            }
        }

        return trappedWater;
    }

}
