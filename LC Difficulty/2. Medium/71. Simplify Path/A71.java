public class A71 {
    public static void main(String[] args) {
        B71 obj = new B71();
        String simplifiedPath = obj.simplifyPath("/a/./b/../../c/");
        System.out.println(simplifiedPath);
    }
}
