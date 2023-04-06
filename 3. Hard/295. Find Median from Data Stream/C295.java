import java.util.PriorityQueue;

class C295 {
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

    public void addNum(int num) {
        System.out.println("________________________");
        System.out.println("Before adding " + num + " to the stream.");
        System.out.println("Max heap: " + maxHeap);
        System.out.println("Min heap: " + minHeap);
        System.out.println();

        maxHeap.offer(num);
        System.out.println("Adding " + num + " to max heap.");
        System.out.println("Max heap: " + maxHeap);
        System.out.println("Min heap: " + minHeap);
        System.out.println();

        minHeap.offer(maxHeap.poll());
        System.out.println("Polling " + num + " from max heap and adding it to min heap.");
        System.out.println("Max heap: " + maxHeap);
        System.out.println("Min heap: " + minHeap);
        System.out.println();

        // keep the sizes of the two heaps balanced
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
            System.out.println("if (maxHeap.size() < minHeap.size()) {");
            System.out.println("Polling " + num + " from min heap and adding it to max heap.");
            System.out.println("Max heap: " + maxHeap);
            System.out.println("Min heap: " + minHeap);
            System.out.println();
        }
        System.out.println("Added " + num + " to the stream.");
        System.out.println("Max heap: " + maxHeap);
        System.out.println("Min heap: " + minHeap);
        System.out.println();

    }

    public double findMedian() {
        // If the size is odd, the median is the top element of maxHeap
        if (maxHeap.size() > minHeap.size()) {
            System.out.println("Median found: " + maxHeap.peek());
            return maxHeap.peek();
        } else {
            // If the size is even, the median is the average of the top elements of maxHeap and minHeap
            double median = (maxHeap.peek() + minHeap.peek()) / 2.0;
            System.out.println("Median found: " + median);
            return median;
        }
    }
}

/**
 * Your B295 object will be instantiated and called as such:
 * B295 obj = new B295();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */