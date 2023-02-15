
class MergeLists {

    L21 head;

    public void addToTheLast(L21 node) {
        if (head == null) {
            head = node;
        } else {
            L21 temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    void printLists() {
        L21 temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
