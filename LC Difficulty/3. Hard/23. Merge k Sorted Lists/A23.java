public class A23 {

    public static void main(String[] args) {
        int k = 3; // Number of linked lists
        // int n = 4; // Number of elements in each list

        // an array of pointers storing the head L23s of the linked lists
        L23[] arr = new L23[k];

        arr[0] = new L23(1);
        arr[0].next = new L23(3);
        arr[0].next.next = new L23(5);
        arr[0].next.next.next = new L23(7);

        arr[1] = new L23(2);
        arr[1].next = new L23(4);
        arr[1].next.next = new L23(6);
        arr[1].next.next.next = new L23(8);

        arr[2] = new L23(0);
        arr[2].next = new L23(9);
        arr[2].next.next = new L23(10);
        arr[2].next.next.next = new L23(11);

        L23 head = B23.mergeKLists(arr);
        printList(head);
    }

    private static void printList(L23 head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
    
}
