import java.util.List;

class A336 {
    public static void main(String[] args) {
        C336 obj = new C336();
        String[] words = {"abcd","dcba","lls","s","sssll"};
        List<List<Integer>> palindromePairs = obj.palindromePairs(words);
        System.out.println(palindromePairs);
    }
    
}
