class y301StringReversal {
    public static void main(String[] args) {
        // Define a sample string
        String original = "Hello, World!";

        // Reverse the string using StringBuilder
        String reversed = new StringBuilder(original).reverse().toString();

        // Print out the original and reversed strings
        System.out.println("Original string: " + original);
        System.out.println("Reversed string: " + reversed);
    }
}
