import java.util.List;

class A315 {
    public static void main(String[] args) {
        B315 obj = new B315();
        // Initializing the input array
        int[] nums = {5, 2, 6, 1};
        // Initializing the result list
        // List<Integer> result = new B315().countSmaller(nums);
        
        List<Integer> result = obj.countSmaller(nums);
        // Printing the result
        System.out.println("result: " + result + "\n");
    }
}
