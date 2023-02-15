public class A82 {
    public static void main(String[] args) {
        L82 head = new L82(1);
        head.next = new L82(2);
        head.next.next = new L82(3);
        head.next.next.next = new L82(3);
        head.next.next.next.next = new L82(4);
        head.next.next.next.next.next = new L82(4);
        head.next.next.next.next.next.next = new L82(5);

        B82 b82 = new B82();
        L82 newHead = b82.deleteDuplicates(head);

        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
    }
}
