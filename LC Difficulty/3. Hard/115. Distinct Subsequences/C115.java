class C115 {
    public int numDistinct(String source, String target) {
        // If the length of the target string is greater than the length of the source string,
        // there cannot be any distinct subsequences of the target in the source.
        if (target.length() > source.length()) {
            return 0;
        }
        
        // Create a 2D array to cache the results of previous function calls.
        // The array is indexed by the current source and target indices.
        int[][] cache = new int[source.length()][target.length()];
        
        // Call the recursive function to count the number of distinct subsequences of the target in the source.
        // Start at index 0 for both the source and target.
        return countDistinctSequences(source, target, 0, 0, cache); 
    }

    public int countDistinctSequences(String source, String target, int sourceIndex, int targetIndex, int[][] cache) {
        // If we've matched all characters in the target, we've found a distinct subsequence of the target in the source.
        if (targetIndex >= target.length()) {
            return 1;
        }
        
        // If we've reached the end of the source string or there aren't enough characters remaining in the source
        // to match the remaining characters in the target, we've reached a dead end and there are no more distinct
        // subsequences of the target in the source.
        if (sourceIndex >= source.length() || source.length() - sourceIndex < target.length() - targetIndex) {
            return 0;
        }
        
        // If we've already calculated the result for the current source and target indices, return the cached result.
        if (cache[sourceIndex][targetIndex] != 0) {
            return cache[sourceIndex][targetIndex] > 0 ? cache[sourceIndex][targetIndex] : 0;
        }

        // Count the number of distinct subsequences that start with the current source and target indices.
        int count = 0;
        
        // If the current characters match, we can include the current character in the subsequence and continue matching.
        if (source.charAt(sourceIndex) == target.charAt(targetIndex)) {
            count += countDistinctSequences(source, target, sourceIndex + 1, targetIndex + 1, cache);
        }
        
        // We can also exclude the current character from the subsequence and continue matching with the next source index.
        count += countDistinctSequences(source, target, sourceIndex + 1, targetIndex, cache);  
        
        // Cache the result for the current source and target indices.
        cache[sourceIndex][targetIndex] = count == 0 ? -1 : count;
        
        // Return the count of distinct subsequences starting with the current source and target indices.
        return count; 
    }
}
