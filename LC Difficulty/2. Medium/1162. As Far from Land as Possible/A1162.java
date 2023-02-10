class A1162 {
    public static void main(String[] args) {
        int[][] grid = { { 1, 0, 1 }, { 0, 0, 0 }, { 1, 0, 1 } };
        B1162 obj = new B1162();
        int result = obj.maxDistance(grid);
        System.out.println("The maximum distance of a cell from a land is: " + result);
    }

}
