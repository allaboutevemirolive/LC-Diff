public class A0024 {
    public static void main(String[] args) {
        // Create a linked list with the example input
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        // Swap every two adjacent nodes in the linked list
        B0024 A0024 = new B0024();
        ListNode swapped = A0024.swapPairs(head);

        // Print the swapped linked list
        while (swapped != null) {
            System.out.print(swapped.val + " ");
            swapped = swapped.next;
        }
    }
}

