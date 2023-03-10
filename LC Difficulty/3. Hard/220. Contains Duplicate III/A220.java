public class A220 {
    public static void main(String[] args) {
        int[] Input = {3, 1, 4, 7, 6, 10};
        int indexDiff  = 2;
        int valueDiff  = 3;
        D220 obj = new D220();
        boolean Output = obj.containsNearbyAlmostDuplicate(Input, indexDiff , valueDiff );
        System.out.println(Output);
    }

}
