public class y312Triangle {

    public static void main(String[] args) {
        int[][] myArray = new int[6][6];

        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[i].length; j++) {
                if (i < j) {
                    myArray[i][j] = (i + 1) * (j + 1);
                }
            }
        }

        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[i].length; j++) {
                System.out.print(myArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}