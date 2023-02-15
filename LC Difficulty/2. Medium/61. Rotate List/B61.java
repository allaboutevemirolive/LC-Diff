class B61 {
    
    public L61 rotateRight(L61 head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int len = 1;
        L61 tail = head;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }
        k %= len;
        if (k == 0) return head;
        L61 fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        L61 slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        L61 newHead = slow.next;
        slow.next = null;
        tail.next = head;
        return newHead;
    }
}