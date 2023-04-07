class T98 {
    int val;
    T98 left;
    T98 right;

    T98() {
    }

    T98(int val) {
        this.val = val;
    }

    T98(int val, T98 left, T98 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}