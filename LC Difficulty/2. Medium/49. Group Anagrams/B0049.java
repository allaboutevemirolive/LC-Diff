import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class B0049 {
    
    public List<List<String>> groupAnagrams(String[] strs) {
        // Use a map to store the anagram groups, with the key being a sorted version of the strings
        // and the value being a list of the strings that are anagrams
        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (String s : strs) {
            // Sort the string to create a unique key for the anagram group
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);

            // Add the string to the corresponding anagram group
            List<String> group = anagramGroups.get(key);
            if (group == null) {
                group = new ArrayList<>();
                anagramGroups.put(key, group);
            }
            group.add(s);
        }

        // Convert the map values to a list and return it
        return new ArrayList<>(anagramGroups.values());
    }
}
