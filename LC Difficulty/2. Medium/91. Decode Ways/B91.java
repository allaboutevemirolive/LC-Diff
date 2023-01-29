class B91 {
    public int numDecodings(String s) {
        // base cases:
        // if string is empty or starts with 0, return 0
        if(s.length() == 0 || s.charAt(0) == '0') return 0;
        // if string has only 1 digit, return 1
        if(s.length() == 1) return 1;
        
        // count1 keeps track of number of decodings for the previous character
        // count2 keeps track of number of decodings for the current character
        int count1 = 1, count2 = 1;
        
        // loop through the string starting from the second character
        for(int i = 1; i < s.length(); ++i){
            // get the integer representation of the current character
            int d = s.charAt(i) - '0';
            // get the integer representation of the two-digit sequence
            int dd = (s.charAt(i-1) - '0')*10 + d;
            // count stores the number of decodings for the current character
            int count = 0;
            // if the current character is not 0, add the number of decodings for the previous character
            if(d > 0) count += count2;
            // if the two-digit sequence is between 10 and 26 inclusive, add the number of decodings for the two characters before
            if(dd >= 10 && dd <= 26) count += count1;
            // update count1 to be the number of decodings for the two characters before
            count1 = count2;
            // update count2 to be the number of decodings for the current character
            count2 = count;
        }
        // return the number of decodings for the last character
        return count2;
    }
}
