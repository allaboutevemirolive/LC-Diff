import java.util.ArrayList;
import java.util.List;

class B89 {
    int nums = 0;

    public List<Integer> grayCode(int n) {
        // initializing an empty list to store the gray code sequence
        List<Integer> res = new ArrayList<>();
        // calling the helper function
        fun(res, n);
        return res;
    }

    void fun(List<Integer> res, int n) {
        // if n is 0, add the current value of nums to the result list
        if (n == 0) {
            res.add(nums);
            return;
        }
        // recursively call the helper function with n-1
        fun(res, n - 1);
        // perform a bitwise XOR operation with the value (1<<n-1) and assign the result
        // to nums
        nums ^= (1 << n - 1);
        // recursively call the helper function with n-1
        fun(res, n - 1);
    }
}
