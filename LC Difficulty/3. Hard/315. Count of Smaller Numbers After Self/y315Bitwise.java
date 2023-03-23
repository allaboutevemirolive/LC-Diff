public class y315Bitwise {
    public static void main(String[] args) {
        int numIndex = 10;
        while (numIndex > 0) {
            System.out.println(numIndex + " ");
            int bitwise = -numIndex & numIndex;
            System.out.println("-numIndex: " + Integer.toBinaryString(-numIndex));
            System.out.println("numIndex : " + Integer.toBinaryString(numIndex));
            System.out.println("bitwise  : " + Integer.toBinaryString(bitwise));
            numIndex += bitwise;
            System.out.println();
        }
    }
}
