public class A86 {
    public static void main(String[] args) {
        B86 b86 = new B86();
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        int x = 3;
        ListNode partitioned = b86.partition(head, x);
        while (partitioned != null) {
            System.out.print(partitioned.val + " ");
            partitioned = partitioned.next;
        }
    }
}
