public class A0002 {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(2);
        ListNode nextl11 = new ListNode(4);
        ListNode nextl12 = new ListNode(3);
        l1.next = nextl11;
        nextl11.next = nextl12;

        ListNode l2 = new ListNode(5);
        ListNode nextl21 = new ListNode(6);
        ListNode nextl22 = new ListNode(4);
        l2.next = nextl21;
        nextl21.next = nextl22;

        Utils.printList(B0002.addTwoNumbers(l1, l2));

    }

}