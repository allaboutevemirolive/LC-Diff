import java.util.ArrayList;
import java.util.List;

class B212 {

    public List<String> findWords(char[][] board, String[] words) {
        //get the number of rows and columns in the board
        int rows = board.length;
        int cols = board[0].length;
        //initialize the answer as an empty list
        List<String> answer = new ArrayList<>();
        //initialize a list to store the indices of characters in the board
        List<List<P212<Integer, Integer>>> charIndices = new ArrayList<>();
        //initialize a list of 26 lists to store the indices of characters in each list, i.e., a to z
        for (int i = 0; i < 26; i++) {
            charIndices.add(new ArrayList<>());
        }
        //for each character in the board, add its index to the list corresponding to its letter
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                charIndices.get(board[i][j] - 'a').add(new P212<>(i, j));
            }
        }

        //initialize counters for words that start or end with 'a'
        int startsWithA = 0;
        int endsWithA = 0;
        //count the number of words that start or end with 'a'
        for (String word : words) {
            if (word.charAt(0) == 'a') {
                startsWithA++;
            }
            if (word.charAt(word.length() - 1) == 'a') {
                endsWithA++;
            }
        }

        //initialize a boolean to determine if words need to be reversed
        boolean isReverse = false;
        //if there are more words that start with 'a' than end with 'a', reverse all the words
        if (startsWithA > endsWithA) {
            for (int i = 0; i < words.length; i++) {
                isReverse = true;
                words[i] = new StringBuilder(words[i]).reverse().toString();
            }
        }

        //for each word in the list of words
        for (String word : words) {
            boolean flag = false;
            //for each index of the first character of the word in the board
            for (P212<Integer, Integer> index : charIndices.get(word.charAt(0) - 'a')) {
                //use DFS to search for the word in the board
                flag = dfs(0, index.getKey(), index.getValue(), board, word, rows, cols);
                //if the word is found, add it to the answer and break out of the loop
                if (flag) {
                    //if the words have been reversed, reverse the word back
                    if (isReverse) {
                        word = new StringBuilder(word).reverse().toString();
                    }
                    answer.add(word);
                    break;
                }
            }
        }
        //return the list of words found in the board
        return answer;
    }

    // Function to perform DFS on the board to check if the given word can be constructed
    public boolean dfs(int idx, int i, int j, char[][] board, String word, int rows, int cols) {
        // Base case: if all characters of the word have been found on the board
        if (idx == word.length()) {
            return true;
        }
        // Check if current position is within the bounds of the board
        if (i >= 0 && i < rows && j >= 0 && j < cols) {
            // Check if current character on board matches with the current character in word
            if (board[i][j] != word.charAt(idx)) {
                return false;
            }
            // Mark the current position on board as visited
            char originalChar = board[i][j];
            board[i][j] = '$';
            // Recursively check the neighbouring positions of the current position for the next character of the word
            boolean answer = 
                    dfs(idx + 1, i + 1, j, board, word, rows, cols) ||
                    dfs(idx + 1, i - 1, j, board, word, rows, cols) ||
                    dfs(idx + 1, i, j + 1, board, word, rows, cols) ||
                    dfs(idx + 1, i, j - 1, board, word, rows, cols);
            // Restore the original character on board at the current position
            board[i][j] = originalChar;
            return answer;
        } else {
            return false;
        }
    }

}
