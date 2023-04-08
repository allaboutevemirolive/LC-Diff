class B352 {
    Node352 r;
    int s;

    public B352() {
        r = null;
        s = 0;
    }

    public void addNum(int value) {
        if (r == null || r.s - 1 > value) {
            Node352 n = new Node352(value);
            n.next = r;
            r = n;
            s++;
            return;
        }
        Node352 curr = r;
        Node352 prev = null;
        boolean flag = false;
        while (curr != null) {
            if (curr.s - 1 > value)
                break;
            if (curr.e + 1 >= value && curr.s - 1 <= value) {
                if (value - 1 == curr.e) {
                    curr.e = value;
                    flag = true;
                } else if (value + 1 == curr.s) {
                    curr.s = value;
                }
                break;
            }
            prev = curr;
            curr = curr.next;
        }
        if ((curr != null && curr.s - 1 > value && prev.e + 1 < value) || curr == null) {
            Node352 n = new Node352(value);
            prev.next = n;
            n.next = curr;
            s++;
        } else if (flag) {
            while (curr != null && curr.next != null) {
                if (curr.e + 1 >= curr.next.s) {
                    curr.e = curr.next.e;
                    curr.next = curr.next.next;
                    s--;
                }
                curr = curr.next;
            }
        }
    }

    public int[][] getIntervals() {
        int[][] res = new int[s][2];
        Node352 curr = r;
        int i = 0;
        while (curr != null) {
            res[i][0] = curr.s;
            res[i++][1] = curr.e;
            curr = curr.next;
        }
        return res;
    }
}