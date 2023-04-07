import java.util.ArrayList;
import java.util.List;

public class A140 {
    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");

        B140 obj = new B140();
        List<String> wordBreaks = obj.wordBreak(s, wordDict);
        System.out.println(wordBreaks);
    }
}
