import java.util.List;

public class A0049 {
    
    public static void main(String[] args) {
        B0049 b0049 = new B0049();
    
        String[] strs = {"hello", "world", "olleh", "dlrow"};
        List<List<String>> anagramGroups = b0049.groupAnagrams(strs);
    
        // Print out the anagram groups
        for (List<String> group : anagramGroups) {
            System.out.println(group);
        }
    }
    
}
