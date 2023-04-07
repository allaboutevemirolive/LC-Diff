import java.util.Random;

class A295 {
    public static void main(String[] args) {
        C295 obj = new C295();
        obj.addNum(1);
        obj.addNum(2);
        System.out.println(obj.findMedian()); // expected output: 1.5
        obj.addNum(3);
        System.out.println(obj.findMedian()); // expected output: 2.0
        obj.addNum(4);
        System.out.println(obj.findMedian());
        obj.addNum(5);
        System.out.println(obj.findMedian()); 

        // // Large test case
        // C295 obj2 = new C295();
        // Random rand = new Random();
        // long startTime = System.currentTimeMillis(); // start the timer
        // for (int i = 0; i < 100000; i++) {
        //     int num = rand.nextInt(201) - 100; // generating random numbers between -100 and 100
        //     obj2.addNum(num);
        // }
        // long endTime = System.currentTimeMillis(); // end the timer
        // double duration = (endTime - startTime) ; // calculate the duration in seconds
        // System.out.println("Median of 100000 random numbers: " + obj2.findMedian());
        // System.out.println("Time taken: " + duration + " ms");
    }

}
