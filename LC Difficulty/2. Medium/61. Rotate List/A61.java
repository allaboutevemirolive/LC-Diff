public class A61 {

    public static void main(String[] args) {
        B61 b0061 = new B61();
        L61 head = new L61(1);
        head.next = new L61(2);
        head.next.next = new L61(3);
        head.next.next.next = new L61(4);
        head.next.next.next.next = new L61(5);
        int k = 2;
        L61 rotatedHead = b0061.rotateRight(head, k);
        L61 current = rotatedHead;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }

    }
}
