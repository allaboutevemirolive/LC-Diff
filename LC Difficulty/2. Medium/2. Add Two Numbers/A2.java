public class A2 {

    public static void main(String[] args) {

        T2 l1 = new T2(2);
        T2 nextl11 = new T2(4);
        T2 nextl12 = new T2(3);
        l1.next = nextl11;
        nextl11.next = nextl12;

        T2 l2 = new T2(5);
        T2 nextl21 = new T2(6);
        T2 nextl22 = new T2(4);
        l2.next = nextl21;
        nextl21.next = nextl22;

        printList(B2.addTwoNumbers(l1, l2));

    }

    private static void printList(T2 head) {
        T2 current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }

}