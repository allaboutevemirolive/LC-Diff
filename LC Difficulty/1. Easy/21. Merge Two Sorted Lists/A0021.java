
class A0021 {

    public static void main(String[] args) {

        MergeLists list1 = new MergeLists();
        MergeLists list2 = new MergeLists();

        list1.addToTheLast(new L21(5));
        list1.addToTheLast(new L21(10));
        list1.addToTheLast(new L21(15));

        list2.addToTheLast(new L21(2));
        list2.addToTheLast(new L21(3));
        list2.addToTheLast(new L21(20));

        list1.head = new B0021().mergeTwoLists(list1.head, list2.head);

        list1.printLists();
    }
}
