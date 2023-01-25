
class A0021 {

    public static void main(String[] args) {

        MergeLists list1 = new MergeLists();
        MergeLists list2 = new MergeLists();

        list1.addToTheLast(new ListNode(5));
        list1.addToTheLast(new ListNode(10));
        list1.addToTheLast(new ListNode(15));

        list2.addToTheLast(new ListNode(2));
        list2.addToTheLast(new ListNode(3));
        list2.addToTheLast(new ListNode(20));

        list1.head = new B0021().mergeTwoLists(list1.head, list2.head);

        list1.printLists();
    }
}
