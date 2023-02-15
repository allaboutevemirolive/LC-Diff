public class A86 {
    public static void main(String[] args) {
        B86 b86 = new B86();
        L86 head = new L86(1);
        head.next = new L86(4);
        head.next.next = new L86(3);
        head.next.next.next = new L86(2);
        head.next.next.next.next = new L86(5);
        head.next.next.next.next.next = new L86(2);
        int x = 3;
        L86 partitioned = b86.partition(head, x);
        while (partitioned != null) {
            System.out.print(partitioned.val + " ");
            partitioned = partitioned.next;
        }
    }
}
