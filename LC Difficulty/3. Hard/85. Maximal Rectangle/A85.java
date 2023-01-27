public class A85 {
    public static void main(String[] args) {
        B85 b85 = new B85();
        char[][] matrix = { 
            { '1', '0', '1', '0', '0' },
            { '1', '0', '1', '1', '1' },
            { '1', '1', '1', '1', '1' },
            { '1', '0', '0', '1', '0' } 
        };
        int result = b85.maximalRectangle(matrix);
        System.out.println(result);
    }
}
