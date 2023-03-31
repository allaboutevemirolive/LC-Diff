import java.util.List;

class A336 {
    public static void main(String[] args) {
        B336 obj = new B336();
        String[] words = {"abcd","dcba","lls","s","sssll"};
        List<List<Integer>> palindromePairs = obj.palindromePairs(words);
        System.out.println(palindromePairs);
    }
    
}
