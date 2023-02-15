public class B24 {

    public L24 swapPairs(L24 head) {
        if (head == null || head.next == null) {
            return head;
        }

        L24 second = head.next;
        head.next = swapPairs(second.next);
        second.next = head;
        return second;
    }
}
