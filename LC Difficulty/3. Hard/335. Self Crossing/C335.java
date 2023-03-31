// https://massivealgorithms.blogspot.com/2016/02/leetcode-self-crossing.html
// Consider test case : { 2, 2, 4, 4, 3, 3 }; { 1, 2, 3, 2, 2 };
class C335 {
    public boolean isSelfCrossing(int[] x) {
        // x array isn't enough. Minimum 4 elements.
        if (x.length <= 3) {
            return false;
        }
        int i = 2;

        // keep spiraling outward / abnormal shape
        // Base case: if there is more element in array that we need to iterate
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

        // transition from spiraling outward to spiraling inward
        if ((i >= 4 && x[i] >= x[i - 2] - x[i - 4]) || (i == 3 && x[i] == x[i - 2])) {
            // If Abnormal, check if the second opposite has same length or not i
            // If Normal, check if the second opposite has same length or not
            x[i - 1] -= x[i - 3];
        }
        // Move to the next straight line
        i++;
        // Check if there is still spiral need to iterate
        // keep spiraling inward
        while (i < x.length) {
            // If the last spiral is bigger than the updated x[i - 1] (check the code above) or x[i - 2] (opposite to the last spiral)
            if (x[i] >= x[i - 2]) {
                return true;
            }
            // keep spiraling inward
            i++;
        }
        return false;
    }
}
