public class B19 {
    
    public static L19 removeNthFromEnd(L19 head, int n) {
        L19 dummy = new L19(0);
        dummy.next = head;
        L19 first = dummy;
        L19 second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
    
}
