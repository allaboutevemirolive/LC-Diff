public class A92 {
    public static void main(String[] args) {
        L92 head = new L92(1);
        head.next = new L92(2);
        head.next.next = new L92(3);
        head.next.next.next = new L92(4);
        head.next.next.next.next = new L92(5);

        int m = 2, n = 4;

        L92 newHead = new B92().reverseBetween(head, m, n);

        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
    }

}
