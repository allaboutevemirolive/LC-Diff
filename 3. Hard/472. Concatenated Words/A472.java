import java.util.List;

public class A472 {
    public static void main(String[] args) {
        B472 obj = new B472();
        String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        List<String> concatenatedWords = obj.findAllConcatenatedWordsInADict(words);
        System.out.println(concatenatedWords);
    }
    
}
