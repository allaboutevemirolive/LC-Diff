public class A466 {
    public static void main(String[] args) {
        C466 solution = new C466();

        String s1 = "acb";
        int n1 = 4;
        String s2 = "ab";
        int n2 = 2;

        int result = solution.getMaxRepetitions(s1, n1, s2, n2);
        System.out.println(result);
    }
}
