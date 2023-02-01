import java.util.Arrays;

class B1626 {
    public int bestTeamScore(int[] scores, int[] ages) {

        int numPlayers = scores.length;
        int[][] players = new int[numPlayers][2];

        for (int i = 0; i < numPlayers; i++) {
            players[i][0] = scores[i];
            players[i][1] = ages[i];
        }

        Arrays.sort(players, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int maxAge = 0;
        for (int age : ages) {
            maxAge = Math.max(maxAge, age);
        }

        int[] bitTree = new int[maxAge + 1];
        int highestScore = 0;

        for (int[] player : players) {
            int currentScore = player[0] + queryBIT(bitTree, player[1]);

            updateBIT(bitTree, player[1], currentScore);

            highestScore = Math.max(highestScore, currentScore);
        }
        return highestScore;
    }

    private int queryBIT(int[] bitTree, int age) {
        int bestScore = Integer.MIN_VALUE;
        for (int i = age; i > 0; i -= i & (-i)) {
            bestScore = Math.max(bestScore, bitTree[i]);
        }
        return bestScore;
    }

    private void updateBIT(int[] bitTree, int age, int currentScore) {
        for (int i = age; i < bitTree.length; i += i & (-i)) {
            bitTree[i] = Math.max(bitTree[i], currentScore);
        }
    }
}