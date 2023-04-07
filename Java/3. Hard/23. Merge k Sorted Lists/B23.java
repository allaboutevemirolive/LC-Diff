import java.util.PriorityQueue;

public class B23 {
    // This method merges k sorted linked lists into one sorted linked list
    public static L23 mergeKLists(L23[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        // Create a priority queue to store the k linked lists
        int k = lists.length;
        PriorityQueue<L23> heap = new PriorityQueue<>(k, (a, b) -> a.val - b.val);

        // Add the first node of each linked list to the priority queue
        for (L23 list : lists) {
            if (list != null) {
                heap.offer(list);
            }
        }

        // Create a dummy node as the head of the new linked list
        L23 head = new L23(0);
        L23 curr = head;

        // Keep polling the minimum node from the priority queue and adding it to the new linked list
        while (!heap.isEmpty()) {
            L23 min = heap.poll();
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
