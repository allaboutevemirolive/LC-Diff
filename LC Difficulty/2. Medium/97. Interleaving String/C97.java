class C97 {
    // two-dimensional boolean array to store invalid combinations
    private boolean[][] invalidCombination;
    // char arrays to store input strings
    private char[] firstString;
    private char[] secondString;
    private char[] resultString;
    
    // method to check if s3 is an interleaved version of s1 and s2
    public boolean isInterleave(String s1, String s2, String s3) {
        // convert strings to char arrays
        firstString = s1.toCharArray();
        secondString = s2.toCharArray();
        resultString = s3.toCharArray();
    
        // get the length of strings s1 and s2
        int lengthOfString1 = s1.length();
        int lengthOfString2 = s2.length();
    
        // return false if the length of s1 and s2 is not equal to the length of s3
        if (lengthOfString1 + lengthOfString2 != s3.length()) return false;
    
        // initialize the invalidCombination array with dimensions lengthOfString1 + 1 and lengthOfString2 + 1
        invalidCombination = new boolean[lengthOfString1 + 1][lengthOfString2 + 1];
    
        // call the checkInterleaving method to check if s3 is an interleaved version of s1 and s2
        return checkInterleaving(0, 0, 0);
    }
    
    public boolean checkInterleaving(int i, int j, int k) {
        // return false if the combination of i and j has already been marked as invalid
        if (invalidCombination[i][j]) return false;
    
        // return true if all characters of s3 have been checked
        if (k == resultString.length) return true;
    
        // check if the current character of s3 can be formed by either the current character of s1 or the current character of s2 
        // i represent firstString. j represent secondString, k represent resultString
        boolean isValid = (i < firstString.length && firstString[i] == resultString[k] && checkInterleaving(i + 1, j, k + 1)) ||
                            (j < secondString.length && secondString[j] == resultString[k] && checkInterleaving(i, j + 1, k + 1));
    
        // mark the combination of i and j as invalid if the current character of s3 cannot be formed by either the current character of s1 or the current character of s2
        if (!isValid) invalidCombination[i][j] = true;
    
        return isValid;
    }
    }