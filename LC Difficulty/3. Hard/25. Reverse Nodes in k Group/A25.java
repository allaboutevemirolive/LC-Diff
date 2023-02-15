public class A25 {

    public static void main(String[] args) {
        // Create a linked list with the example input
        L25 head = new L25(1);
        head.next = new L25(2);
        head.next.next = new L25(3);
        head.next.next.next = new L25(4);
        head.next.next.next.next = new L25(5);

        // Reverse the linked list in groups of 2
        int k = 2;
        B25 b25 = new B25();
        L25 reversed = b25.reverseKGroup(head, k);

        // Print the reversed linked list
        while (reversed != null) {
            System.out.print(reversed.val + " ");
            reversed = reversed.next;
        }
    }
}
