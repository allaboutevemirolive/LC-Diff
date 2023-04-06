class B75 {
    public void sortColors(int[] nums) {
        int i = 0, j = nums.length - 1;
        for (int k = 0; k <= j; k++) {
            if (nums[k] == 0) {
                int temp = nums[i];
                nums[i++] = nums[k];
                nums[k] = temp;
            } else if (nums[k] == 2) {
                int temp = nums[j];
                nums[j--] = nums[k];
                nums[k] = temp;
                k--;
            }
        }
    }
}