import java.util.List;

class A301 {
    public static void main(String[] args) {
        B301 obj = new B301();
        String input = "()())()";
        List<String> result = obj.removeInvalidParentheses(input);
        System.out.println(result);
    }
}
