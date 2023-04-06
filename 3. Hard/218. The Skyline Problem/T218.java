class T218 {

    int x;
    int h;
    T218 next;

    T218() {
    }

    T218(int x, int h) {
        this.x = x;
        this.h = h;
    }

    void insert(T218 n) {
        n.next = next;
        next = n;
    }
}