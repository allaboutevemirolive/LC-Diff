import java.util.List;

public class A89 {
    public static void main(String[] args) {
        B89 b89 = new B89();
        int n = 2;
        List<Integer> graycode = b89.grayCode(n);
        System.out.println(graycode);
    }
}
