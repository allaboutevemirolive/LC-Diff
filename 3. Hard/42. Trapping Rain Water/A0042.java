public class A0042 {

    public static void main(String[] args) {

        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int trappedWater = B0042.trap(height);
        System.out.println("The amount of water that can be trapped is " + trappedWater);
    }
}
