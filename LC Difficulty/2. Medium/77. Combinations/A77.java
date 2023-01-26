import java.util.List;

public class A77 {
    public static void main(String[] args) {
        B77 b77 = new B77();
        int n = 4, k = 2;
        List<List<Integer>> combinations = b77.combine(n, k);
        System.out.println(combinations);
    }
}
