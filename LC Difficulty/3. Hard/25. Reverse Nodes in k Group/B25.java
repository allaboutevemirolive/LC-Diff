public class B25 {

    public L25 reverseKGroup(L25 head, int k) {
        // Initialize a pointer curr to the head of the list
        // Initialize a variable count to 0
        L25 curr = head;
        int count = 0;
        
        // Iterate through the list while curr is not null 
        // and count is less than k
        while (curr != null && count < k) {
            // Update curr to point to the next node
            curr = curr.next;
            // Increment count by 1
            count++;
        }
        
        // If count is equal to k, it means that there are k nodes in the current group
        if (count == k) {
            // Recursively call the method with curr as the new head, which is the k+1th node
            // and k as the second parameter
            curr = reverseKGroup(curr, k);
            
            // Iterate through the group of k nodes, reversing their order
            while (count > 0) {
                // Use a temporary variable temp to store the next node
                L25 temp = head.next;
                // Update the next pointer of the current node to point to curr
                head.next = curr;
                // Update curr to be the current node
                curr = head;
                // Update the current node to be the node stored in temp
                head = temp;
                // Decrement count by 1
                count--;
            }
            // Update head to be curr
            head = curr;
        }
        // Return the modified head
        return head;
    }
}
