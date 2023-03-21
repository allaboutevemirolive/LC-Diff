import java.util.Arrays;

class B295 {
    static final IntPriorityQueue left = new IntPriorityQueue(30000);
    static final IntPriorityQueue right = new IntPriorityQueue(30000);

    boolean leftTooBig = false;

    public B295() {
        left.clear();
        right.clear();
        left.add(Integer.MIN_VALUE + 1);
        right.add(Integer.MIN_VALUE + 1);
    }

    public void addNum(int num) {
        if (leftTooBig) {
            final int leftPeek = left.peek();
            if (num < leftPeek) {
                right.add(-leftPeek);
                left.moveDown(num);
            } else {
                right.add(-num);
            }
        } else {
            final int rightPeek = -right.peek();
            if (num > rightPeek) {
                right.moveDown(-num);
                left.add(rightPeek);
            } else {
                left.add(num);
            }
        }
        leftTooBig = !leftTooBig;
    }

    public double findMedian() {
        return leftTooBig ? left.peek() : 0.5 * (left.peek() - right.peek());
    }

    public static final class IntPriorityQueue {
        private int[] vals;
        private int size;

        IntPriorityQueue(int maxSize) {
            this.vals = new int[maxSize];
        }

        void add(int v) {
            vals[size] = v;
            moveUp(size++);
        }

        int poll() {
            int r = vals[0];
            moveDown(vals[--size]);
            return r;
        }

        int peek() {
            return vals[0];
        }

        private void moveDown(int val) {
            int idx = 0;
            for (int l = 1; l < size; l = (idx << 1) + 1) {
                int r = l + 1;
                int candidate = r < size && vals[r] > vals[l] ? r : l;
                int valCandidate = vals[candidate];
                if (val < valCandidate) {
                    vals[idx] = valCandidate;
                    idx = candidate;
                } else {
                    break;
                }
            }
            vals[idx] = val;
        }

        private void moveUp(int idx) {
            int valIdx = vals[idx];
            while (idx > 0) {
                int parent = (idx - 1) >> 1;
                int valParent = vals[parent];
                if (valIdx <= valParent) {
                    break;
                }
                vals[parent] = valIdx;
                vals[idx] = valParent;
                idx = parent;
            }
        }

        int size() {
            return size;
        }

        boolean isEmpty() {
            return size == 0;
        }

        void clear() {
            size = 0;
        }

        @Override
        public String toString() {
            return Arrays.toString(Arrays.copyOf(vals, size));
        }
    }
}

/**
 * Your B295 object will be instantiated and called as such:
 * B295 obj = new B295();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */