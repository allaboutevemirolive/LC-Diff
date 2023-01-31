import java.util.ArrayList;
import java.util.List;

class B131 {
    int length;
    boolean[][] isPalindrome;
    List<List<String>> partitions;

    /*
     * Finds all the possible partitions of a string.
     * index: the starting index of the string
     * partition: a list of substrings that form a partition
     * s: the input string
     */
    private void findPartitions(int index, List<String> partition, String s) {
        // If we have processed the entire string, add the partition to the result
        if (index == length) {
            partitions.add(new ArrayList<>(partition));
            return;
        }

        // Iterate over substrings from the starting index to the end
        for (int i = index; i < length; i++) {
            // If the substring is not a palindrome, skip it
            if (!isPalindrome[index][i]) continue;
            // Add the substring to the partition
            partition.add(s.substring(index, i + 1));
            // Recursively find partitions for the remaining string
            findPartitions(i + 1, partition, s);
            // Remove the substring from the partition as we backtrack
            partition.remove(partition.size() - 1);
        }
    }

    public List<List<String>> partition(String s) {
        length = s.length();
        isPalindrome = new boolean[length][length];
        partitions = new ArrayList<>();

        // Pre-compute the palindrome substrings by checking if each substring is a palindrome
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= i; j++) {
                // Check if the current substring is a palindrome
                if (s.charAt(j) == s.charAt(i) && (j + 1 > i - 1 || isPalindrome[j + 1][i - 1])) {
                    isPalindrome[j][i] = true;
                }
            }
        }

        // Start the recursive search for partitions
        findPartitions(0, new ArrayList<>(), s);
        return partitions;
    }
}
