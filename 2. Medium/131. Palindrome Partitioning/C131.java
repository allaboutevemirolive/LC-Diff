import java.util.ArrayList;
import java.util.List;

class C131 {
    boolean[][] isPalindrome;
    String[][] palindromes;
    List<List<String>> result;
    int length;
    ArrayList<String> helperList;

    public void fillPalindromicArray(String str) {
        length = str.length();
        isPalindrome = new boolean[length][length];
        palindromes = new String[length][length];

        for (int i = 0; i < length; i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = 0; i < length - 1; i++) {
            isPalindrome[i][i + 1] = str.charAt(i) == str.charAt(i + 1);
        }
        for (int g = 2; g < length; g++) {
            for (int startIndex = 0; startIndex < length; startIndex++) {
                int endIndex = startIndex + g;
                if (endIndex < length && str.charAt(startIndex) == str.charAt(endIndex)) {
                    isPalindrome[startIndex][endIndex] |= isPalindrome[startIndex + 1][endIndex - 1];
                }
            }
        }

        for (int startIndex = 0; startIndex < length; startIndex++) {
            for (int endIndex = startIndex; endIndex < length; endIndex++) {
                if (isPalindrome[startIndex][endIndex]) {
                    palindromes[startIndex][endIndex] = str.substring(startIndex, endIndex + 1);
                }
            }
        }
    }

    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        fillPalindromicArray(s);
        helperList = new ArrayList<>(length);
        fill(0);
        return result;
    }

    public void fill(int startIndex) {
        if (startIndex >= length) {
            result.add(new ArrayList<>(helperList));
            return;
        }
        for (int endIndex = startIndex; endIndex < length; endIndex++) {
            if (isPalindrome[startIndex][endIndex]) {
                helperList.add(palindromes[startIndex][endIndex]);
                fill(endIndex + 1);
                helperList.remove(helperList.size() - 1);
            }
        }
    }
}