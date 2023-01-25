public class A0061 {

    public static void main(String[] args) {
        B0061 b0061 = new B0061();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int k = 2;
        ListNode rotatedHead = b0061.rotateRight(head, k);
        ListNode current = rotatedHead;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }

    }
}
