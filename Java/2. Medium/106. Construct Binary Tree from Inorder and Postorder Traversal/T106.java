class T106 {
    public int val;
    public T106 left;
    public T106 right;

    public T106(int val) {
        this.val = val;
    }

    public T106(int val, T106 left, T106 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
