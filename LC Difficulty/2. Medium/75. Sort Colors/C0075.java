class C0075 {
    public void sortColors(int[] nums) {
        int red = 0;
        int white = 0;
        int blue = 0;
        
        for (int num : nums) {
            if (num == 0) {
                red++;
            } else if (num == 1) {
                white++;
            } else {
                blue++;
            }
        }
        
        int i = 0;
        while (red-- > 0) nums[i++] = 0;
        while (white-- > 0) nums[i++] = 1;
        while (blue-- > 0) nums[i++] = 2;
    }
}