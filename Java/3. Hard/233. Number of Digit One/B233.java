public class B233 {
    public int countDigitOne(int n) {
        int count = 0;
		// variable "i" is used to keep track of the current digit position being considered. 
		// "the left of the current position" refers to the digits with higher place values than "i", 
		// "the right of the current position" refers to the digits with lower place values than "i".
		//  "i" represent place value like ones, tens, hundreds and so on
        for (long i = 1; i <= n; i *= 10) {
            // find the digits in current position
			// calculates a value that represents the next digit position to the left of the current position.
            long divider = i * 10;
            // number of digits from current position to right end of n
			// Subtracting i from n % divider, the code effectively removes any digits 
			// to the right of the current position(place value)
			// Number 123, the digit "1" is in the "hundreds" position, the digit "2" is in 
			// the "tens" position, and the digit "3" is in the "ones" position.
			// Adding 1 to the result ensures that the current digit position itself is 
			// also included in the count. 
            long nums1 = n % divider - i + 1;
			// prevent negative values
			// Estimate the maximum of ones that could appear at the current digit position
			// if n is a small number and i is a large number, then nums1 can become negative
            long nums2 = Math.max(nums1, 0);
            // prevent extra 1's
			// The minimum between nums2 and i represents 
			// the actual number of ones that appear at the current digit position.
            long nums3 = Math.min(nums2, i);
            // nums4 is the number of 1's in the remaining left part of n
            // multiplied by i to take into account the total number of 1's 
            // at the current position
			// represents the number of ones that appear in the digits to the left of the current position.
            long nums4 = (n / divider) * i;
            // get total number of 1's at the current position
            count += nums4 + nums3;
        }
        return count;
    }
}