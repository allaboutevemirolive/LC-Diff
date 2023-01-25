import java.util.PriorityQueue;

public class B23 {
    // This method merges k sorted linked lists into one sorted linked list
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        // Create a priority queue to store the k linked lists
        int k = lists.length;
        PriorityQueue<ListNode> heap = new PriorityQueue<>(k, (a, b) -> a.val - b.val);

        // Add the first node of each linked list to the priority queue
        for (ListNode list : lists) {
            if (list != null) {
                heap.offer(list);
            }
        }

        // Create a dummy node as the head of the new linked list
        ListNode head = new ListNode(0);
        ListNode curr = head;

        // Keep polling the minimum node from the priority queue and adding it to the new linked list
        while (!heap.isEmpty()) {
            ListNode min = heap.poll();
            curr.next = min;
            curr = curr.next;
            // Add the next node of the polled node to the priority queue
            if (min.next != null) {
                heap.offer(min.next);
            }
        }

        return head.next;
    }
}
