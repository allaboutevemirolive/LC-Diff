import java.util.List;

public class A131 {
    public static void main(String[] args) {
        B131 solution = new B131();
        String s = "bananas";
        List<List<String>> partitions = solution.partition(s);

        System.out.println("Palindrome Partitions of " + s + ":");
        for (List<String> partition : partitions) {
            System.out.println(partition);
        }
    }
}
