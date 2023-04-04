import java.util.List;
class A336 {
    public static void main(String[] args) {
        E336 obj = new E336();
        // ["a","b","c","ab","ac","aa"]
        // ["abcd","dcba","lls","s","sssll"]
        String[] words = {"a","b","c","ab","ac","aa"};
        List<List<Integer>> palindromePairs = obj.palindromePairs(words);
        System.out.println(palindromePairs);
    }
}
