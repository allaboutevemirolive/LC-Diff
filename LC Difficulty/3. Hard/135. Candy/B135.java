class B135 {
    public int candy(int[] ratings) {
        
        // Initialize candies array with 1 candy per child
        int[] candies = new int[ratings.length];
        for (int i = 0; i < candies.length; ++i) {
            candies[i] = 1;
        }

        // Scan from left to right, and give more candies to higher rated children
        for (int i = 1; i < candies.length; ++i) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Scan from right to left, and give more candies to higher rated children
        for (int i = candies.length - 2; i >= 0; --i) {
            if (ratings[i] > ratings[i + 1] && candies[i] < candies[i + 1] + 1) {
                candies[i] = candies[i + 1] + 1;
            }
        }

        // Calculate the total number of candies
        int sum = 0;
        for (int i = 0; i < candies.length; ++i) {
            sum += candies[i];
        }
        return sum;
    }
}
