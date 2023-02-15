class B92 {

    public L92 reverseBetween(L92 head, int m, int n) {
        if (head == null) return null; // return null if head is null
        L92 dummy = new L92(0); // create a dummy node as placeholder for new head
        dummy.next = head; // set dummy's next as the original head
        L92 pre = dummy; // pointer to keep track of node before reversal
        for (int i = 0; i < m - 1; i++) // iterate m-1 times
            pre = pre.next; //update pre to be the node before the start of reversal

        L92 start = pre.next; // pointer to the start of reversal
        L92 then = start.next; // pointer to the node after the start of reversal

        for (int i = 0; i < n - m; i++) {
            start.next = then.next; // set start's next as the node after then
            then.next = pre.next; // set then's next as pre's next
            pre.next = then; // set pre's next as then
            then = start.next; // update then to be the node after start
        }

        return dummy.next; // return the new head (next of dummy)

    }
}
