import java.util.HashSet;
import java.util.List;
import java.util.Set;

class B127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> startSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        
        startSet.add(beginWord);
        endSet.add(endWord);
        
        Set<String> dictionary = new HashSet<>(wordList);
        if (!dictionary.contains(endWord)) {
            return 0;
        }
        
        return search(startSet, endSet, dictionary, true, 1);
    }

    private int search(Set<String> startSet, Set<String> endSet, Set<String> dictionary, boolean isForward, int count) {
        if (startSet.isEmpty() || endSet.isEmpty()) {
            return 0;
        }
        
        count++;
        dictionary.removeAll(startSet);
        Set<String> nextSet = new HashSet<>();
        
        for (String word : startSet) {
            char[] letters = word.toCharArray();
            
            for (int i = 0; i < letters.length; i++) {
                char originalChar = letters[i];
                
                for (char c = 'a'; c <= 'z'; c++) {
                    letters[i] = c;
                    String newWord = new String(letters);
                    
                    if (!dictionary.contains(newWord)) {
                        continue;
                    }
                    
                    if (endSet.contains(newWord)) {
                        return count;
                    }
                    
                    nextSet.add(newWord);
                }
                
                letters[i] = originalChar;
            }
        }
        
        if (nextSet.size() > endSet.size()) {
            return search(endSet, nextSet, dictionary, false, count);
        } else {
            return search(nextSet, endSet, dictionary, true, count);
        }
    }
}
