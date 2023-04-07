public class A24 {
    public static void main(String[] args) {
        // Create a linked list with the example input
        L24 head = new L24(1);
        head.next = new L24(2);
        head.next.next = new L24(3);
        head.next.next.next = new L24(4);

        // Swap every two adjacent nodes in the linked list
        B24 A0024 = new B24();
        L24 swapped = A0024.swapPairs(head);

        // Print the swapped linked list
        while (swapped != null) {
            System.out.print(swapped.val + " ");
            swapped = swapped.next;
        }
    }
}

