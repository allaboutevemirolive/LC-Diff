public class A0059 {
    public static void main(String[] args) {
        B0059 b0059 = new B0059();
        int n = 3;
        int[][] matrix = b0059.generateMatrix(n);
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                System.out.println(matrix[i][j] + " ");
            }
        }
    }
}
