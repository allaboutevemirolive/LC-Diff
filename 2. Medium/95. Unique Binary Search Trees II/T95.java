class T95 {
    int val;
    T95 left;
    T95 right;
    T95() {}
    T95(int val) { this.val = val; }
    T95(int val, T95 left, T95 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}