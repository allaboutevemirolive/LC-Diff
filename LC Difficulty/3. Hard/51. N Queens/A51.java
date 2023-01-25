import java.util.List;

class A51 {
    public static void main(String[] args) {
        C51 c51 = new C51();
        int n = 4; // Example value, replace with desired input
        List<List<String>> ans = c51.solveNQueens(n);
        for (List<String> list : ans) {
            for (String s : list) {
                System.out.println(s);
            }
            System.out.println();
        }
    }
}
