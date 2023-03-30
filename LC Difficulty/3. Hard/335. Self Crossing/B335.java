class Solution {
    public boolean isSelfCrossing(int[] x) {
        if (x.length <= 3) {
            return false;
        }
        int i = 2;
        System.out.println("i: " + i);
        while (i < x.length && x[i] > x[i - 2]) {
            i++;
        }
        System.out.println("i: " + i);
        if (i >= x.length) {
            return false;
        }
        if ((i >= 4 && x[i] >= x[i - 2] - x[i - 4]) ||
                (i == 3 && x[i] == x[i - 2])) {
            x[i - 1] -= x[i - 3];
        }
        i++;
        while (i < x.length) {
            if (x[i] >= x[i - 2]) {
                return true;
            }
            i++;
        }
        
        return false;
    }
}