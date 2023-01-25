import java.util.List;

public class A68 {
    public static void main(String[] args) {
        B68 b68 = new B68();
        String[] words = {"the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
        int maxWidth = 16;
        List<String> justifiedLines = b68.fullJustify(words, maxWidth);
        for (String line : justifiedLines) {
            System.out.println(line);
        }
    }
    
}
