
public class A0001 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        
        int[] indices = B0001.twoSum(nums, target);
        
        System.out.println("Indices: [" + indices[0] + ", " + indices[1] + "]");
    }
}
