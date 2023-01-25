public class A0019 {
    
    public static void main(String[] args) {
        // Create a linked list with some test data
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
    
        // Call the removeNthFromEnd function to remove the second node from the end of the list
        head = B0019.removeNthFromEnd(head, 2);
    
        // Print the resulting linked list
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }
    
}
