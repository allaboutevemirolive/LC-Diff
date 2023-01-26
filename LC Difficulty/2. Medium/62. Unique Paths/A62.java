public class A62 {
    public static void main(String[] args) {
        B62 obj = new B62();
        int m = 3;
        int n = 3;

        int result = obj.uniquePaths(m, n);

        System.out.println("The number of uniqe paths is: "+result);
    }
}
