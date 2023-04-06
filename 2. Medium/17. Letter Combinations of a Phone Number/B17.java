import java.util.ArrayList;
import java.util.List;

class B17 {
    // This is a 2D array that represents the mapping of digits to letters 
    char[][] mapping = new char[][] { 
        { 'a', 'b', 'c' }, 
        { 'd', 'e', 'f' }, 
        { 'g', 'h', 'i' },
        { 'j', 'k', 'l' }, 
        { 'm', 'n', 'o' }, 
        { 'p', 'q', 'r', 's' }, 
        { 't', 'u', 'v' }, 
        { 'w', 'x', 'y', 'z' } 
    };

    // This is the main function that will be called to return all possible letter combinations
    public List<String> letterCombinations(String digits) {
        int length = digits.length();
        // Initialize an ArrayList to store the result
        List<String> result = new ArrayList<>();

        // If the input `digits` is empty, return an empty list
        if (length == 0) return result;

        // Call the `findCombinations` helper function to find all combinations
        findCombinations(result, digits, 0, new StringBuilder());
        return result;
    }

    // This is a helper function to find all possible combinations
    private void findCombinations(List<String> result, String digits, int currentIndex, StringBuilder currentCombination) {
        // If the current index is equal to the length of the `digits`, it means we have found a combination
        // Add the current combination to the result list
        if (currentIndex == digits.length()) {
            result.add(currentCombination.toString());
            return;
        }

        // Get the index of the digit in the `mapping` array
        int digitIndex = digits.charAt(currentIndex) - '0' - 2;
        // Loop through the letters of the current digit
        for (char letter : mapping[digitIndex]) {
            // Append the current letter to the current combination
            currentCombination.append(letter);
            // Recursively call the `findCombinations` function with updated parameters
            findCombinations(result, digits, currentIndex + 1, currentCombination);
            // Remove the last letter from the current combination to try the next letter
            currentCombination.setLength(currentCombination.length() - 1);
        }
    }
}
