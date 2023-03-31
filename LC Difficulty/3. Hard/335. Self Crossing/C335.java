// https://massivealgorithms.blogspot.com/2016/02/leetcode-self-crossing.html
class C335 {
    public boolean isSelfCrossing(int[] x) {
        // x array isn't enough. Minimum 4 elements.
        if (x.length <= 3) {
            return false;
        }
        int i = 2;
        // Base case: if there more array that we need to iterate
        // Base case: if current line is longer than the opposite line
        while (i < x.length && x[i] > x[i - 2]) {
            i++;
        }
        // Base case: if we reach the end of the array and there is no self-crossing
        if (i >= x.length) {
            return false;
        }

        // https://leetcode.com/problems/self-crossing/solutions/729133/how-to-explain-to-interviewer-335-self-crossing/

        // Base case: 
        // (i >= 4 && x[i] >= x[i - 2] - x[i - 4]) => x[i] >= x[i - 2] - x[i - 4]
        // Abnormal shape/spiral consisting of 5 lines or more / i >= 4
        // Example opposite
        // Opposite 1: x[i] + x[i - 4] >= x[i - 2]
        // Opposite 2: x[i - 1] >= x[i - 3]  OR  x[i - 1] + x[i - 5] >= x[i - 3]
        // Check the link for visual explanation

        // Base case: 
        // (i == 3 && x[i] == x[i - 2])
        // Normal shape/spiral consisting of 4 lines / i == 3
        // Opposite 1 : x[i] == x[i - 2]
        // Opposite 2 : x[i - 1] == x[i - 3]
        // Check if current line is equal to the opposite line

        if ((i >= 4 && x[i] >= x[i - 2] - x[i - 4]) || (i == 3 && x[i] == x[i - 2])) {
            // If Abnormal, check if the second opposite has same length or not
            // If Normal, check if the second opposite has same length or not
            x[i - 1] -= x[i - 3];
        }
        // Move to the next straight line
        i++;
        // If i still not reach the end of the array
        while (i < x.length) {
            // If current line is longer than the opposite line
            if (x[i] >= x[i - 2]) {
                return true;
            }
            // Move to the next straight line
            i++;
        }
        return false;
    }
}
