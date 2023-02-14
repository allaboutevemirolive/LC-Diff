class T105 {
    int val;
    T105 left;
    T105 right;

    T105(int val) {
        this.val = val;
    }

    T105(int val, T105 left, T105 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
