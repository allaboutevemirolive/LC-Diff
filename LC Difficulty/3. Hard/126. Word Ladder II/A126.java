import java.util.ArrayList;
import java.util.List;

public class A126 {
    public static void main(String[] args) {
        B126 b126 = new B126();
        
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        List<List<String>> result = b126.findLadders(beginWord, endWord, wordList);
        
        System.out.println("Result: " + result);
    }
}
