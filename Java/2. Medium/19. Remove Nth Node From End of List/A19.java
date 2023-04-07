public class A19 {
    
    public static void main(String[] args) {
        // Create a linked list with some test data
        L19 head = new L19(1);
        head.next = new L19(2);
        head.next.next = new L19(3);
        head.next.next.next = new L19(4);
        head.next.next.next.next = new L19(5);
    
        // Call the removeNthFromEnd function to remove the second node from the end of the list
        head = B19.removeNthFromEnd(head, 2);
    
        // Print the resulting linked list
        L19 curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }
    
}
