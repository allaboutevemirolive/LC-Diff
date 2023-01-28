import java.util.Arrays;
import java.util.List;

class C89 {
    public List<Integer> grayCode(int n) {
        int edge = 1 << n; // 1 shifted left by n bits, this is the upper limit of the gray code sequence
        Integer[] res = new Integer[edge]; // array to store the gray code sequence
        res[0] = 0; // first element of the gray code sequence is always 0
        int length = 1; // length of current gray code sequence
        int i;
        int j = 1;
        while (j != edge) {
            length = j; // update the length of the gray code sequence
            for (i = length - 1; i >= 0; i--) {
                res[j] = res[i] | length; // calculate the next gray code by or-ing with the length
                j++; // increment index
            }
        }
        return Arrays.asList(res); // convert array to list and return
    }
}