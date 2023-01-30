import java.util.ArrayList;
import java.util.List;

public class C93 {
    char[] original;
	char[] buffer;
	ArrayList<String> r = new ArrayList<>();
	
	// main method to return all possible valid IP addresses
	public List<String> restoreIpAddresses(String s) {
		// convert input string to char array
        original = s.toCharArray();
		// buffer to store IP address
        buffer = new char[original.length + 3];
		// call restore method
        restore(0, 0);
		// return list of valid IP addresses
        return r;
    }
	
	void restore(final int start, final int done) {
		int v = 0;
		// loop through original char array
		for (int i = start; i < original.length; i++) {
			final char c = original[i];
			// calculate value of v
			v = v * 10 + c - '0';
			// break loop if value of v is greater than 255
			if (v > 255) break;
			// add character to buffer
			buffer[i + done] = c;
			// if number of dots is less than 3
			if (done < 3) {
				// add dot to buffer
				buffer[i + done + 1] = '.';
				// call restore method with updated parameters
				restore(i + 1, done + 1);
			} 
			// if i is equal to length of original char array minus 1
			else if (i == original.length - 1) {
				// add buffer as new IP address to result list
				r.add(new String(buffer));
			}
			// if value of v is 0, break loop
			if (v == 0) break;
		}
	}
}
