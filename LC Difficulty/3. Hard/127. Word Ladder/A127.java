import java.util.Arrays;
import java.util.List;

public class A127 {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> worldList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        B127 obj = new B127();
        int shortestTransformationSequenceLength = obj.ladderLength(beginWord, endWord, worldList);

        System.out.println("Shortest transformation sequence length: " + shortestTransformationSequenceLength);
    }
}
