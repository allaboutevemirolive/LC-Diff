import java.util.Arrays;

class B1626 {
    // This function returns the maximum score of a team that can be formed from given scores and ages of players
    public int bestTeamScore(int[] scores, int[] ages) {

        // numPlayers is the number of players
        int numPlayers = scores.length;

        // Create a 2D array 'players' where each player's score and age is stored
        int[][] players = new int[numPlayers][2];

        // Store the score and age of each player in the 2D array
        for (int i = 0; i < numPlayers; i++) {
            players[i][0] = scores[i];
            players[i][1] = ages[i];
        }

        // Sort the players based on their scores, in case of a tie, sort them based on their ages
        Arrays.sort(players, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        // maxAge is the maximum age among all players
        int maxAge = 0;
        for (int age : ages) {
            maxAge = Math.max(maxAge, age);
        }

        // bitTree is the binary indexed tree used to store the scores
        int[] bitTree = new int[maxAge + 1];

        // highestScore is the maximum score that can be achieved by a team
        int highestScore = 0;

        // For each player
        for (int[] player : players) {
            // currentScore is the score of the team when this player is included
            int currentScore = player[0] + queryBIT(bitTree, player[1]);

            // Update the score of the team in the binary indexed tree
            updateBIT(bitTree, player[1], currentScore);

            // Update the highestScore if the currentScore is greater
            highestScore = Math.max(highestScore, currentScore);
        }
        // Return the highestScore
        return highestScore;
    }

    // This function returns the maximum score of a team that can be formed from players with ages less than or equal to the given age
    private int queryBIT(int[] bitTree, int age) {
        int bestScore = Integer.MIN_VALUE;
        // Traverse the binary indexed tree to find the maximum score
        for (int i = age; i > 0; i -= i & (-i)) {
            bestScore = Math.max(bestScore, bitTree[i]);
        }
        return bestScore;
    }

    // This function updates the score of a team in the binary indexed tree
    private void updateBIT(int[] bitTree, int age, int currentScore) {
        // Update the scores in the binary indexed tree
        for (int i = age; i < bitTree.length; i += i & (-i)) {
            bitTree[i] = Math.max(bitTree[i], currentScore);
        }
    }
}
