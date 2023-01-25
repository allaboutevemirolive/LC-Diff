public class A0055 {

    public static void main(String[] args) {
        B0055_ReverseOrder b0055 = new B0055_ReverseOrder();

        /*
         * HINT : each element in the array REPRESENTS your MAXIMUM JUMP length at that position.
         * 
         * 2,3,1,0,4 true
         * 
         * 3,2,1,0,4 false
         * 
         * 2,3,1,1,4 true
         * 
         * 2,0,6,9,8,4,5,0,8,9,1,2,9,6,8,8,0,6,3,1 true
         * 
         * 1,1,1,1,1,0,1,1,1,1,1 false
         * 
         * 1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1 false
         * 
         * 2,5,0,0 true
         */

        int[] nums = { 2, 5, 0, 0 };
        boolean result = b0055.canJump(nums);
        System.out.println(result);
    }
}
