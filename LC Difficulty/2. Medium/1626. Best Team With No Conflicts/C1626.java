import java.util.Arrays;

class C1626 {
    public int bestTeamScore(int[] scores, int[] ages) {
        // number of players
        int numberOfPlayers = scores.length;
        // 2D array to store age and score of each player
        int[][] playerDetails = new int[numberOfPlayers][2];
        // storing player details into playerDetails array
        for (int i = 0; i < numberOfPlayers; i++) {
            playerDetails[i][0] = ages[i];
            playerDetails[i][1] = scores[i];
        }
        // sorting the player details based on ages
        Arrays.sort(playerDetails, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        // scores of selected players
        int[] scoresOfSelectedPlayers = new int[numberOfPlayers];
        // best team score
        int bestTeamScore = 0;
        // loop through all players
        for (int i = 0; i < numberOfPlayers; i++) {
            scoresOfSelectedPlayers[i] = playerDetails[i][1];
            // loop through all previous players
            for (int j = 0; j < i; j++) {
                // if previous player score is less than or equal to current player score
                if (playerDetails[j][1] <= playerDetails[i][1]) {
                    scoresOfSelectedPlayers[i] = Math.max(scoresOfSelectedPlayers[i], scoresOfSelectedPlayers[j] + playerDetails[i][1]);
                }
            }
            // update best team score
            bestTeamScore = Math.max(bestTeamScore, scoresOfSelectedPlayers[i]);
        }
        return bestTeamScore;
    }
}