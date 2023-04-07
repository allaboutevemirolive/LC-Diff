import java.util.ArrayList;
import java.util.List;

class D131 {
    int stringLength;
    boolean[][] isPalindrome;
    String[][] allSubstrings;
    List<List<String>> partitions;

    void findPartitions(int currentIndex, ArrayList<String> partitionList) {
        if (currentIndex == stringLength) {
            partitions.add(new ArrayList<>(partitionList));
            return;
        }

        for (int i = currentIndex + 1; i <= stringLength; i++) {
            if (!isPalindrome[currentIndex][i]) continue;
            partitionList.add(allSubstrings[currentIndex][i]);
            findPartitions(i, partitionList);
            partitionList.remove(partitionList.size() - 1);
        }
    }

    public List<List<String>> partition(String s) {
        stringLength = s.length();
        isPalindrome = new boolean[stringLength + 1][stringLength + 1];
        allSubstrings = new String[stringLength + 1][stringLength + 1];
        for (int i = 0; i < stringLength; i++) {
            for (int j = i + 1; j <= stringLength; j++) {
                allSubstrings[i][j] = s.substring(i, j);
                isPalindrome[i][j] = isStringPalindrome(allSubstrings[i][j]);
            }
        }

        partitions = new ArrayList<>();
        findPartitions(0, new ArrayList<>());
        return partitions;
    }

    boolean isStringPalindrome(String s) {
        int leftPointer = 0;
        int rightPointer = s.length() - 1;
        while (leftPointer < rightPointer) {
            if (s.charAt(leftPointer) != s.charAt(rightPointer)) return false;
            leftPointer++;
            rightPointer--;
        }
        return true;
    }
}
