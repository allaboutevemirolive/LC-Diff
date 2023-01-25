public class A0045 {
    
    public static void main(String[] args) {
        B0045 solution = new B0045();
        
        // Test case 1
        int[] A = {2, 3, 1, 1, 4};
        int result = solution.jump(A);
        System.out.println(result);  // Output: 2
        
        // Test case 2
        int[] B = {1, 1, 1, 1};
        result = solution.jump(B);
        System.out.println(result);  // Output: 3
        
        // Test case 3
        int[] C = {5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0};
        result = solution.jump(C);
        System.out.println(result);  // Output: 2
    }
    
}
