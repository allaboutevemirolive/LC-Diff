class C92 {
    public L92 reverseBetween(L92 head, int left, int right) {
        if (left == 1) return reverseN(head, right);

        head.next = reverseBetween(head.next, left - 1, right - 1);

        return head;
    }

    private L92 reverseN(L92 head, int n) {
        if (n == 1) return head;

        L92 newHead = reverseN(head.next, n - 1);
        L92 headNext = head.next;
        head.next = headNext.next;
        headNext.next = head;

        return newHead;
    }
}