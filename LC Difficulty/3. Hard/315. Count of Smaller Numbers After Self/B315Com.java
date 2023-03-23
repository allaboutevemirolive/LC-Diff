import java.util.Arrays;
import java.util.List;

class B315Com {

    public List<Integer> countSmaller(int[] nums) {
        
        int minNum = Integer.MAX_VALUE;
        int maxNum = Integer.MIN_VALUE;
        
        // Find the minimum and maximum values in the array
        for (int num : nums) {
            minNum = Math.min(minNum, num);
            maxNum = Math.max(maxNum, num);
        }
        
        // Avoids having to deal with negative indices in the count array
        // because arrays in Java cannot have negative indices
        // This is safe because the minimum value is guaranteed to be positive
        // and the maximum value is guaranteed to be less than the length of the array
        // ArrayIndexOutOfBoundsException will be thrown if this is not the case
        minNum--;
        
        // keep track of how many times each number appears in the input array.
        // 1-indexed to avoid having to deal with negative indices
        int[] count = new int[maxNum - minNum + 1];
        
        // store the counts of smaller elements to the right of each element in the input array.
        // Since we don't know the values of these counts beforehand, 
        // we cannot use 'int' type and initialize them with any value.
        Integer[] result = new Integer[nums.length];
        
        // Iterate over the array backwards
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            int numIndex = num - minNum - 1;
            int smallerCount = 0;
            System.out.println("i: " + i + ", num: " + num +  ", smallerCount: " + smallerCount + ", minNum: " + minNum);
            System.out.println("numIndex: " + numIndex + " = " + num + " - " + minNum + " - 1");

            // Count the number of smaller elements to the right of the current element
            while (numIndex > 0) {
                System.out.println();
                System.out.println("------------------------------------");
                System.out.println("(numIndex > 0)");
                System.out.println("Count: \n" + Arrays.toString(count));
                smallerCount += count[numIndex];
                System.out.println("numIndex : " + numIndex + ", count[numIndex]: " + count[numIndex] + ", smallerCount: " + smallerCount);                
                System.out.println();

                int bitwise = (-numIndex & numIndex);
                System.out.println("-numIndex(bit): " + Integer.toBinaryString(-numIndex) + " or " + -numIndex);
                System.out.println("numIndex(bit) : " + Integer.toBinaryString(numIndex) + " or " + numIndex);
                System.out.println("bitwise(bit)  : " + Integer.toBinaryString(bitwise) + " or " + bitwise);
                System.out.println("numIndex(new) : " +  (numIndex - bitwise) + " = " + numIndex + " - " + bitwise );
                numIndex -= bitwise;
                
            }
            System.out.println();
            // For example, if nums is [5, 2, 6, 1], and we have just processed the element at 
            // index i = 2 (i.e., the element with value 6), 
            // and the count of smaller elements to the right of 6 is 1, 
            // then the line of code result[i] = smallerCount; will update the value of result[2] to 1.
            result[i] = smallerCount;
            System.out.println("result[i] = smallerCount : \n" + Arrays.toString(result));

            // ensure that we can use numIndex as an index into the count array 
            // without encountering any index out of bounds errors or negative indices.
            numIndex = num - minNum;
            System.out.println("numIndex: " + numIndex + " = " + num + " - " + minNum);
            System.out.println();
            while (numIndex < count.length) {
                System.out.println("------------------------------------");
                System.out.println("(numIndex < count.length)");
                System.out.println("Before\ncount: \n" + Arrays.toString(count));
                count[numIndex]++;
                System.out.println("After\ncount: \n" + Arrays.toString(count));
                // calculates the value of the least significant non-zero bit of numIndex
                System.out.println();

                int bitwise2 = (-numIndex & numIndex);
                System.out.println("-numIndex(bit) : " + Integer.toBinaryString(-numIndex) + " or " + -numIndex);
                System.out.println("numIndex(bit)  : " + Integer.toBinaryString(numIndex) + " or " + numIndex);
                System.out.println("bitwise2(bit)  : " + Integer.toBinaryString(bitwise2) + " or " + bitwise2);
                System.out.println("numIndex(new)  : " +  (numIndex + bitwise2) + " = " + numIndex + " + " + bitwise2);
                numIndex += bitwise2;
                
                System.out.println();

            }
            System.out.println("====================================");
        }

        return Arrays.asList(result);
    }
}
