
public class B0002 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // create a dummy node to store the result and a pointer to the current node
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // initialize a carry variable to 0
        int carry = 0;

        // loop until both input lists are empty and there is no carry left
        while (l1 != null || l2 != null || carry > 0) {
            // get the value of the current node in each list, or 0 if the list is null
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;

            // add the values and the carry, and calculate the new carry
            int sum = x + y + carry;
            carry = sum / 10;

            // create a new node with the last digit of the sum and add it to the result
            current.next = new ListNode(sum % 10);
            current = current.next;

            // move to the next node in each list
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        // return the result without the dummy node
        return dummy.next;
    }

}
