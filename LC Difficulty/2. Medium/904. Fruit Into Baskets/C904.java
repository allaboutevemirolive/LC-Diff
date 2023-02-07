class C904 {
    public int totalFruit(int[] fruits) {
        if (fruits.length == 0) {
            return 0;
        }
        int maxFruits = 0;
        int curFruits = 1;
        int lastSameTree = 0;
        int prevTreeType = -1;
        for (int i = 1; i < fruits.length; i++) {
            if (fruits[i] == fruits[i-1]) {
                curFruits++;
            } else if (fruits[i] == prevTreeType || prevTreeType == -1) {
                lastSameTree = i;
                prevTreeType = fruits[i-1];
                curFruits++;
            } else {
                maxFruits = Math.max(maxFruits, curFruits);
                prevTreeType = fruits[i-1];
                curFruits = i - lastSameTree + 1;
                lastSameTree = i;
            }
        }
        
        maxFruits = Math.max(maxFruits, curFruits);
        
        return maxFruits;
    }
}