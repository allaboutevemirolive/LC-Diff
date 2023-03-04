public class A174 {
    public static void main(String[] args) {
        int[][] dungeon = {{-2,-3,3}, {-5,-10,1}, {10,30,-5}};
        B174 obj = new B174();
        int minInitialHealth = obj.calculateMinimumHP(dungeon);
        System.out.println("Minimum initial health required: " + minInitialHealth);
    }
}
