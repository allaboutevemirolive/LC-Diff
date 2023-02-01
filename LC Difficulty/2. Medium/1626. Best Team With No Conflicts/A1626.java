public class A1626 {
    public static void main(String[] args) {
        int[] scores = {4,1,2,3};
        int[] ages = {5,3,7,1};
        B1626 b1626 = new B1626();
        C1626 c1626 = new C1626();
        int bestScore = c1626.bestTeamScore(scores, ages);
        System.out.println(bestScore);
    }
}
