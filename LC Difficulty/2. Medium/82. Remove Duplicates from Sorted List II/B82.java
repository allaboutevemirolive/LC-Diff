class B82 {
    public ListNode deleteDuplicates(ListNode head) {
        // Edge case: return the head if it is null or the list only has one node
        if (head == null || head.next == null) {
            return head;
        }

        // Create a dummy node to keep track of the previous node in the linked list
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;

        // Iterate through the linked list
        while (curr != null) {
            // Move the current pointer to the last duplicate value in a sequence of duplicates
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
            }

            // Check if the previous node's next pointer is the same as the current pointer
            if (prev.next == curr) {
                // If so, move the previous pointer to the next node
                prev = prev.next;
            } else {
                // If not, set the previous node's next pointer to the current node's next pointer
                // effectively removing the duplicates from the list
                prev.next = curr.next;
            }

            // Move the current pointer to the next node
            curr = curr.next;
        }

        // Return the linked list starting from the dummy node's next pointer
        return dummy.next;
    }
}
