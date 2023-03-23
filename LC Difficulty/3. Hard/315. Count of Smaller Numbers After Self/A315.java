import java.util.List;

class A315 {
    public static void main(String[] args) {
        B315Com obj = new B315Com();
        // Initializing the input array
        int[] nums = {5, 2, 6, 1};

        // List<Integer> result = new B315().countSmaller(nums);

        List<Integer> result = obj.countSmaller(nums);
        // Printing the result
        System.out.println("result: " + result);
    }
}
